package kz.olzhas.employeeserver.mapper.employee;

import kz.olzhas.employeeserver.dto.employee.RequestRoleDto;
import kz.olzhas.employeeserver.mapper.Mappable;
import kz.olzhas.employeeserver.model.employee.JobRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RequestRoleMapper extends Mappable<JobRole, RequestRoleDto> {
}
