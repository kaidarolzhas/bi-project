package kz.olzhas.employeeserver.mapper.employee;

import kz.olzhas.employeeserver.dto.employee.RequestRoleDto;
import kz.olzhas.employeeserver.mapper.Mappable;
import kz.olzhas.employeeserver.model.employee.JobRole;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = "spring")
public class RequestRoleMapper implements Mappable<JobRole, RequestRoleDto> {

    @Override
    public JobRole toEntity(RequestRoleDto dto) {
        return JobRole.builder()
                .id(dto.getId())
                .role(dto.getRole())
                .oklad(dto.getOklad())
                .bonus(dto.getBonus())
                .restaurantId(dto.getRestaurantId())
                .build();
    }

    @Override
    public RequestRoleDto toDto(JobRole entity) {
        return RequestRoleDto.builder()
                .id(entity.getId())
                .role(entity.getRole())
                .oklad(entity.getOklad())
                .bonus(entity.getBonus())
                .restaurantId(entity.getRestaurantId())
                .build();
    }

    @Override
    public List<JobRole> toEntityList(List<RequestRoleDto> dto) {
        if (dto == null) {
            return null;
        } else {
            List<JobRole> list = new ArrayList(dto.size());
            Iterator var3 = dto.iterator();

            while(var3.hasNext()) {
                RequestRoleDto RequestRoleDto = (RequestRoleDto)var3.next();
                list.add(this.toEntity(RequestRoleDto));
            }

            return list;
        }
    }

    @Override
    public List<RequestRoleDto> toDtoList(List<JobRole> entity) {
        if (entity == null) {
            return null;
        } else {
            List<RequestRoleDto> list = new ArrayList(entity.size());
            Iterator var3 = entity.iterator();

            while(var3.hasNext()) {
                JobRole restaurant = (JobRole)var3.next();
                list.add(this.toDto(restaurant));
            }

            return list;
        }
    }
}
