package kz.olzhas.employeeserver.controller;

import kz.olzhas.employeeserver.dto.EmployeeRequest;
import kz.olzhas.employeeserver.dto.EmployeeResponse;
import kz.olzhas.employeeserver.mapper.EmployeeRequestMapper;
import kz.olzhas.employeeserver.mapper.EmployeeResponceMapper;
import kz.olzhas.employeeserver.model.Employee;

import kz.olzhas.employeeserver.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeRequestMapper employeeRequestMapper;
    private final EmployeeResponceMapper employeeResponceMapper;
    private final EmployeeService employeeService;
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmployeeResponse getEmployee(@PathVariable Long id) throws BadRequestException {
        return employeeResponceMapper.toDto(employeeService.getEmployee(id));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void createEmployee(@RequestBody EmployeeRequest employeeRequest){
        Employee employee = employeeRequestMapper.toEntity(employeeRequest);
        employeeService.createEmployee(employee);
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<EmployeeResponse> getEmployees() throws BadRequestException {
        return employeeResponceMapper.toDtoList(employeeService.getEmployees());
    }
}
