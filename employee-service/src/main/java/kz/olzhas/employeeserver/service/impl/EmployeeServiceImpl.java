package kz.olzhas.employeeserver.service.impl;

import kz.olzhas.employeeserver.model.Employee;
import kz.olzhas.employeeserver.repository.EmployeeRepository;
import kz.olzhas.employeeserver.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    @Override
    public Employee getEmployee(Long id) throws BadRequestException {
        return employeeRepository.findById(id)
                .orElseThrow(BadRequestException::new);

    }

    @Override
    public void createEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAll();
    }
}
