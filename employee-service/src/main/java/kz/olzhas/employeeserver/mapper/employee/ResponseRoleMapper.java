package kz.olzhas.employeeserver.mapper.employee;

import kz.olzhas.employeeserver.dto.employee.ResponseRoleDto;
import kz.olzhas.employeeserver.mapper.Mappable;
import kz.olzhas.employeeserver.model.employee.JobRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ResponseRoleMapper extends Mappable<JobRole, ResponseRoleDto> {
}
