package kz.olzhas.employeeserver.service.impl;

import kz.olzhas.employeeserver.dto.employee.RequestRoleDto;
import kz.olzhas.employeeserver.dto.employee.ResponseRoleDto;
import kz.olzhas.employeeserver.mapper.employee.ResponseRoleMapper;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.repository.employee.EmployeeRepository;
import kz.olzhas.employeeserver.repository.employee.JobRoleRepository;
import kz.olzhas.employeeserver.service.JobRoleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class JobRolesServiceImpl implements JobRoleService {

    private final JobRoleRepository jobRoleRepository;
    private final EmployeeRepository employeeRepository;
    private final ResponseRoleMapper responseRoleDtoMapper;

    @Override
    public void deleteRole(Long id) {
        Optional<JobRole> jobRole = jobRoleRepository.findById(id);
        if (jobRole.isPresent()) {
            List<Employee> employees = employeeRepository.findAllByJobRoleId(id);
            if (!employees.isEmpty()) {
                for (Employee employee : employees) {
                    employee.setJobRole(null);
                }
            }
            jobRoleRepository.deleteById(id);
        }
    }

    public List<ResponseRoleDto> getAll(Long resId) {
        return responseRoleDtoMapper.toDtoList(jobRoleRepository.findAllByRestaurantId(resId));
    }

    @Override
    public Optional<JobRole> getByRole(String role, Long id) {
        return jobRoleRepository.findByRoleAndRestaurantId(role, id);
    }

    @Override
    public void createRoles(RequestRoleDto requestRoleDto, Long resId) {
        JobRole jobRole = JobRole.builder()
                .role(requestRoleDto.getRole().toUpperCase())
                .bonus(requestRoleDto.getBonus())
                .oklad(requestRoleDto.getOklad())
                .restaurantId(resId)
                .build();

        jobRoleRepository.save(jobRole);
    }

    @Override
    public void updateRole(JobRole role) throws BadRequestException {
        Optional<JobRole> jobRole = jobRoleRepository.findById(role.getId());
        JobRole existingRole = jobRole.orElseThrow(() -> new BadRequestException("Job role not found"));
        existingRole.setRole(role.getRole());
        jobRoleRepository.save(jobRole.get());
    }

    @Override
    public Optional<JobRole> getRole(Long id) {
            return jobRoleRepository.findById(id);
    }


}
