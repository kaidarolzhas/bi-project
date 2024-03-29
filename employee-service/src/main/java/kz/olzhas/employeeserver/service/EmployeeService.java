package kz.olzhas.employeeserver.service;

import kz.olzhas.employeeserver.model.Employee;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface EmployeeService {
    Employee getEmployee(Long id) throws BadRequestException;
    void createEmployee(Employee employee);

    List<Employee> getEmployees();
}
