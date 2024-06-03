package kz.olzhas.employeeserver.controller;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.dto.employee.RequestRoleDto;
import kz.olzhas.employeeserver.dto.employee.ResponseRoleDto;
import kz.olzhas.employeeserver.mapper.employee.EmployeeResponseMapper;
import kz.olzhas.employeeserver.mapper.employee.EmployeeRequestMapper;
import kz.olzhas.employeeserver.model.employee.Employee;

import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import kz.olzhas.employeeserver.repository.kpi.KpiFactRepository;
import kz.olzhas.employeeserver.service.EmployeeService;
import kz.olzhas.employeeserver.service.JobRoleService;
import kz.olzhas.employeeserver.service.KpiFactService;
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
    private final KpiFactRepository kpiFactRepository;
    private final EmployeeService employeeService;
    private final JobRoleService jobRoleService;
    private final KpiFactService kpiFactService;
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeRequest getEmployee(@PathVariable Long id) throws BadRequestException {
        EmployeeRequest employeeRequest = employeeRequestMapper.toDto(employeeService.getEmployee(id));
        List<KPIFact> kpiFacts = kpiFactService.kpiFactsByUserId(employeeRequest.getId());
        if(!kpiFacts.isEmpty()){
            employeeRequest.setKpiFacts(kpiFacts);
        }
        return employeeRequest;
    }

    @PostMapping("/{resId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeRequest employeeRequest, @PathVariable Long resId) throws BadRequestException {
        employeeService.createEmployee(employeeRequest,resId);
    }
    @PostMapping("/role/{resId}")
    @ResponseStatus(HttpStatus.OK)
    public void createRole(@RequestBody RequestRoleDto requestRoleDto, @PathVariable Long resId) throws BadRequestException {
        jobRoleService.createRoles(requestRoleDto, resId);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    public void updateEmployee(@RequestBody EmployeeRequest employeeRequest
    ) throws BadRequestException {
        Employee employee = employeeRequestMapper.toEntity(employeeRequest);
        Optional<JobRole> jobRole = jobRoleService.getByRole(employeeRequest.getJobRole().getRole(), employeeRequest.getRestaurantId());
        List<KPIFact> kpiFacts = kpiFactRepository.findAllByEmployeeId(employeeRequest.getId());
        JobRole exJobRole = jobRole.orElseThrow(() -> new BadRequestException("Job role not found"));
        for (int i = 0; i < kpiFacts.size(); i++){
            kpiFacts.get(i).setValue(employeeRequest.getKpiFacts().get(i).getValue());
            kpiFacts.get(i).setMonth(employeeRequest.getKpiFacts().get(i).getMonth());
            kpiFacts.get(i).setYear(employeeRequest.getKpiFacts().get(i).getYear());
            kpiFactRepository.saveAndFlush(kpiFacts.get(i));
        }
        employee.setJobRole(exJobRole);

        employeeService.updateEmployee(employee);
    }

    @PutMapping("/role")
    @ResponseStatus(HttpStatus.OK)
    public void updateRole(@RequestBody RequestRoleDto requestRoleDto
    ) throws BadRequestException {
        JobRole role = JobRole.builder()
                        .id(requestRoleDto.getId())
                                .role(requestRoleDto.getRole())
                .oklad(requestRoleDto.getOklad())
                .bonus(requestRoleDto.getBonus())
                .restaurantId(requestRoleDto.getRestaurantId())
                                        .build();
        jobRoleService.updateRole(role);

    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public boolean deleteEmployee(@PathVariable Long id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/getAll")
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeRequest> getEmployees(@RequestParam("resId") Long resId) throws BadRequestException {
        List<Employee> employees =  employeeService.getEmployees(resId);
        List<EmployeeRequest> employeesRequestList =  employeeRequestMapper.toDtoList(employees);
        for(Employee employee: employees){
            for(EmployeeRequest request:employeesRequestList ) {
                Optional<JobRole> jobRole = jobRoleService.getRole(employee.getJobRole().getId());
                List<KPIFact> kpiFacts = kpiFactService.kpiFactsByUserId(request.getId());
                request.setKpiFacts(kpiFacts);
                jobRole.ifPresent(request::setJobRole);
            }
        };
        return employeesRequestList;
    }

    @GetMapping("/getRoles")
    @ResponseStatus(HttpStatus.OK)
    public List<ResponseRoleDto> getRoles(@RequestParam("resId") Long resId) {
        return jobRoleService.getAll(resId);
    }

    @DeleteMapping("/role/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteRole(@PathVariable Long id){
        jobRoleService.deleteRole(id);
    }

}
