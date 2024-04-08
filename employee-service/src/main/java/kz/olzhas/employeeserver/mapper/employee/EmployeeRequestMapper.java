package kz.olzhas.employeeserver.mapper.employee;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.mapper.Mappable;
import kz.olzhas.employeeserver.model.employee.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeRequestMapper extends Mappable<Employee, EmployeeRequest> {
}
