package kz.olzhas.employeeserver.mapper.employee;

import kz.olzhas.employeeserver.dto.employee.RequestRoleDto;
import kz.olzhas.employeeserver.dto.employee.ResponseRoleDto;
import kz.olzhas.employeeserver.mapper.Mappable;
import kz.olzhas.employeeserver.model.employee.JobRole;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = "spring")
public class ResponseRoleMapper implements Mappable<JobRole, ResponseRoleDto> {

    @Override
    public JobRole toEntity(ResponseRoleDto dto) {
        return JobRole.builder()
                .role(dto.getRole())
                .oklad(dto.getOklad())
                .bonus(dto.getBonus())
                .restaurantId(dto.getRestaurantId())
                .build();
    }

    @Override
    public ResponseRoleDto toDto(JobRole entity) {
        return ResponseRoleDto.builder()
                .role(entity.getRole())
                .oklad(entity.getOklad())
                .bonus(entity.getBonus())
                .restaurantId(entity.getRestaurantId())
                .build();
    }

    @Override
    public List<JobRole> toEntityList(List<ResponseRoleDto> dto) {
        if (dto == null) {
            return null;
        } else {
            List<JobRole> list = new ArrayList(dto.size());
            Iterator var3 = dto.iterator();

            while (var3.hasNext()) {
                ResponseRoleDto responseRoleDto = (ResponseRoleDto) var3.next();
                list.add(this.toEntity(responseRoleDto));
            }

            return list;
        }
    }

    @Override
    public List<ResponseRoleDto> toDtoList(List<JobRole> entity) {
        if (entity == null) {
            return null;
        } else {
            List<ResponseRoleDto> list = new ArrayList(entity.size());
            Iterator var3 = entity.iterator();

            while (var3.hasNext()) {
                JobRole restaurant = (JobRole) var3.next();
                list.add(this.toDto(restaurant));
            }

            return list;
        }
    }
}
