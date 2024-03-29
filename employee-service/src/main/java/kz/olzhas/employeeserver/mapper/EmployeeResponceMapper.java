package kz.olzhas.employeeserver.mapper;

import kz.olzhas.employeeserver.dto.EmployeeResponse;
import kz.olzhas.employeeserver.model.Employee;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EmployeeResponceMapper extends Mappable<Employee, EmployeeResponse> {
}
