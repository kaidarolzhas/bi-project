package kz.olzhas.employeeserver.controller;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.dto.employee.EmployeeResponse;
import kz.olzhas.employeeserver.dto.employee.RequestRoleDto;
import kz.olzhas.employeeserver.dto.employee.ResponseRoleDto;
import kz.olzhas.employeeserver.mapper.employee.EmployeeResponseMapper;
import kz.olzhas.employeeserver.mapper.employee.EmployeeRequestMapper;
import kz.olzhas.employeeserver.mapper.employee.RequestRoleMapper;
import kz.olzhas.employeeserver.mapper.employee.ResponseRoleMapper;
import kz.olzhas.employeeserver.model.employee.Employee;

import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.service.EmployeeService;
import kz.olzhas.employeeserver.service.JobRoleService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRequestMapper employeeRequestMapper;
    private final EmployeeResponseMapper employeeResponseMapper;
    private final RequestRoleMapper requestRoleMapper;
    private final ResponseRoleMapper responseRoleMapper;
    private final EmployeeService employeeService;
    private final JobRoleService jobRoleService;
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse getEmployee(@PathVariable Long id) throws BadRequestException {
        return employeeResponseMapper.toDto(employeeService.getEmployee(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeRequest employeeRequest) throws BadRequestException {
        employeeService.createEmployee(employeeRequest);
    }
    @PostMapping("/role")
    @ResponseStatus(HttpStatus.OK)
    public void createRole(@RequestBody RequestRoleDto requestRoleDto) throws BadRequestException {
        jobRoleService.createRoles(requestRoleDto);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@RequestBody EmployeeRequest employeeRequest
    ) throws BadRequestException {
        Employee employee = employeeRequestMapper.toEntity(employeeRequest);
        Optional<JobRole> jobRole = jobRoleService.getByRole(employeeRequest.getRole());
        jobRole.ifPresent(employee::setJobRole);
        employeeService.updateEmployee(employee);
    }

    @PutMapping("/role")
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@RequestBody RequestRoleDto requestRoleDto
    ) throws BadRequestException {
        JobRole role = JobRole.builder()
                        .id(requestRoleDto.getId())
                                .role(requestRoleDto.getRole())
                                        .build();
        jobRoleService.updateRole(role);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponse> getEmployees() throws BadRequestException {
        return employeeResponseMapper.toDtoList(employeeService.getEmployees());
    }

    @GetMapping("/getRoles")
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseRoleDto> getRoles() {
        List<ResponseRoleDto> responseRoleDtos = jobRoleService.getAll();
        return responseRoleDtos;
    }

    @DeleteMapping("/role/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRole(@PathVariable Long id){
        jobRoleService.deleteRole(id);
    }

}
