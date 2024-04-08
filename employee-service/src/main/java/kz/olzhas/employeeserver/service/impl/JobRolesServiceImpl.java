package kz.olzhas.employeeserver.service.impl;

import kz.olzhas.employeeserver.dto.employee.RequestRoleDto;
import kz.olzhas.employeeserver.dto.employee.ResponseRoleDto;
import kz.olzhas.employeeserver.mapper.employee.RequestRoleMapper;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import kz.olzhas.employeeserver.repository.employee.EmployeeRepository;
import kz.olzhas.employeeserver.repository.employee.JobRoleRepository;
import kz.olzhas.employeeserver.repository.kpi.KpiStandardRepository;
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
    private final KpiStandardRepository kpiStandardRepository;
    private final EmployeeRepository employeeRepository;
    private final RequestRoleMapper requestRoleMapper;

    @Override
    public void deleteRole(Long id) {
        Optional<JobRole> jobRole = jobRoleRepository.findById(id);
        if(jobRole.isPresent()){
            List<Employee> employees = employeeRepository.findAllByJobRoleId(id);
            if(!employees.isEmpty()){
                for(Employee employee :employees){
                    employee.setJobRole(null);
                }
            }
           jobRoleRepository.deleteById(id);
        }
    }

    public List<ResponseRoleDto> getAll(){
        List<JobRole> list = jobRoleRepository.findAll();
        List<ResponseRoleDto> responseRoleDtos = new ArrayList<>();
        for(JobRole jobRole : list){
            responseRoleDtos.add(new ResponseRoleDto(jobRole.getRole()));
        }
        return responseRoleDtos;
    }

    @Override
    public Optional<JobRole> getByRole(String role) {
        return jobRoleRepository.findByRole(role);
    }

    @Override
    public void createRoles(RequestRoleDto requestRoleDto) {
        JobRole jobRole = JobRole.builder()
                .role(requestRoleDto.getRole().toUpperCase())
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


}
