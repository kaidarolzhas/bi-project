package kz.olzhas.employeeserver.mapper.kpi;

import kz.olzhas.employeeserver.dto.employee.ResponseRoleDto;
import kz.olzhas.employeeserver.dto.kpi.KpiStandardDto;
import kz.olzhas.employeeserver.mapper.Mappable;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = "spring")
public class KpiStandardMapper implements Mappable<KpiStandard, KpiStandardDto> {
    @Override
    public KpiStandard toEntity(KpiStandardDto dto) {
        return KpiStandard.builder()
                .id(dto.getId())
                .value(dto.getValue())
                .name(dto.getName())
                .percent(dto.getPercent())
                .jobRole(dto.getJobRole())
                .build();
    }

    @Override
    public KpiStandardDto toDto(KpiStandard entity) {
        return KpiStandardDto.builder()
                .id(entity.getId())
                .value(entity.getValue())
                .name(entity.getName())
                .percent(entity.getPercent())
                .jobRole(entity.getJobRole())
                .build();
    }

    @Override
    public List<KpiStandard> toEntityList(List<KpiStandardDto> dto) {
        if (dto == null) {
            return null;
        } else {
            List<KpiStandard> list = new ArrayList(dto.size());
            Iterator var3 = dto.iterator();

            while (var3.hasNext()) {
                KpiStandardDto responseRoleDto = (KpiStandardDto) var3.next();
                list.add(this.toEntity(responseRoleDto));
            }

            return list;
        }
    }

    @Override
    public List<KpiStandardDto> toDtoList(List<KpiStandard> entity) {
        if (entity == null) {
            return null;
        } else {
            List<KpiStandardDto> list = new ArrayList(entity.size());
            Iterator var3 = entity.iterator();

            while (var3.hasNext()) {
                KpiStandard restaurant = (KpiStandard) var3.next();
                list.add(this.toDto(restaurant));
            }

            return list;
        }
    }
}
