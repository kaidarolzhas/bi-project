package kz.olzhas.employeeserver.service.impl;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.mapper.employee.EmployeeRequestMapper;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import kz.olzhas.employeeserver.repository.employee.EmployeeRepository;
import kz.olzhas.employeeserver.repository.employee.JobRoleRepository;
import kz.olzhas.employeeserver.repository.kpi.KpiFactRepository;
import kz.olzhas.employeeserver.repository.kpi.KpiStandardRepository;
import kz.olzhas.employeeserver.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final JobRoleRepository jobRoleRepository;
    private final KpiStandardRepository kpiStandardRepository;
    private final EmployeeRequestMapper employeeRequestMapper;
    private final KpiFactRepository kpiFactRepository;

    @Override
    public Employee getEmployee(Long id) throws BadRequestException {
        return employeeRepository.findById(id)
                .orElseThrow(BadRequestException::new);

    }

    @Override
    public void createEmployee(EmployeeRequest employeeRequest, Long resId) throws BadRequestException {
        if (employeeRepository.existsByEmail(employeeRequest.getEmail())) {
            throw new BadRequestException("User with this email already exists");
        }

        Optional<JobRole> jobRole = jobRoleRepository.findByRoleAndRestaurantId(employeeRequest.getJobRole().getRole().toUpperCase(), resId);
        if (jobRole.isEmpty()) {
            throw new BadRequestException("Roles dont exist");
        }
        Employee employee = Employee.builder()
                .firstName(employeeRequest.getFirstName())
                .lastName(employeeRequest.getLastName())
                .email(employeeRequest.getEmail())
                .jobRole(jobRole.get())
                .dateOfStart(employeeRequest.getDateOfStart())
                .restaurantId(resId)
                .build();

        employeeRepository.save(employee);

        List<KpiStandard> kpiStandards = kpiStandardRepository.findAllByJobRole(jobRole.get());
        List<KPIFact> kpiFacts = new ArrayList<>();
        if (!kpiStandards.isEmpty()) {
            for (KpiStandard kpiStandard : kpiStandards) {
                kpiFacts.add(
                        KPIFact.builder()
                                .employee(employee)
                                .name(kpiStandard.getName())
                                .percent(kpiStandard.getPercent())
                                .build()
                );
            }
        }
        kpiFactRepository.saveAll(kpiFacts);
    }


    @Override
    public List<Employee> getEmployees(Long resId) {
        return employeeRepository.findAllByRestaurantId(resId);
    }

    @Override
    public void updateEmployee(Employee newEmployee) throws BadRequestException {
        Optional<Employee> employee = employeeRepository.findById(newEmployee.getId());
        Optional<JobRole> jobRole = jobRoleRepository.findByRoleAndRestaurantId(newEmployee.getJobRole().getRole(), newEmployee.getRestaurantId());
        Employee existingEmployee = employee.orElseThrow(() -> new BadRequestException("Job role not found"));
        JobRole exJobRole = jobRole.orElseThrow(() -> new BadRequestException("Job role not found"));
        existingEmployee.setFirstName(newEmployee.getFirstName());
        existingEmployee.setLastName(newEmployee.getLastName());
        existingEmployee.setJobRole(exJobRole);
        existingEmployee.setDateOfStart(newEmployee.getDateOfStart());

        employeeRepository.save(existingEmployee);
    }

    @Override
    public boolean deleteEmployee(Long id) {
        boolean flag = false;
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);
        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            employeeRepository.delete(employee);
            flag = true;
        }
        return flag;
    }
}
