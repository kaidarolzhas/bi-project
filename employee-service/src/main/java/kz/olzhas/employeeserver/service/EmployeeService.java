package kz.olzhas.employeeserver.service;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.model.employee.Employee;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(Long id) throws BadRequestException;
    void createEmployee(EmployeeRequest employeeRequest) throws BadRequestException;

    List<Employee> getEmployees();

    void updateEmployee(Employee employee) throws BadRequestException;
    boolean deleteEmployee(Long id);
}
