package kz.olzhas.employeeserver.mapper;

import kz.olzhas.employeeserver.dto.EmployeeRequest;
import kz.olzhas.employeeserver.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeRequestMapper extends Mappable<Employee, EmployeeRequest> {
}
