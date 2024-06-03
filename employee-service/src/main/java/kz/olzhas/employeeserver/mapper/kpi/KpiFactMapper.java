package kz.olzhas.employeeserver.mapper.kpi;

import kz.olzhas.employeeserver.dto.kpi.KpiFactDto;
import kz.olzhas.employeeserver.dto.kpi.KpiStandardDto;
import kz.olzhas.employeeserver.mapper.Mappable;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Mapper(componentModel = "spring")
public class KpiFactMapper implements Mappable<KPIFact, KpiFactDto > {
    @Override
    public KPIFact toEntity(KpiFactDto dto) {
        return KPIFact.builder()
                .id(dto.getId())
                .name(dto.getName())
                .value(dto.getValue())
                .percent(dto.getPercent())
                .month(dto.getMonth())
                .year(dto.getYear())
                .build();
    }

    @Override
    public KpiFactDto toDto(KPIFact entity) {
        return KpiFactDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .value(entity.getValue())
                .percent(entity.getPercent())
                .month(entity.getMonth())
                .year(entity.getYear())
                .build();
    }

    @Override
    public List<KPIFact> toEntityList(List<KpiFactDto> dto) {
        if (dto == null) {
            return null;
        } else {
            List<KPIFact> list = new ArrayList(dto.size());
            Iterator var3 = dto.iterator();

            while (var3.hasNext()) {
                KpiFactDto responseRoleDto = (KpiFactDto) var3.next();
                list.add(this.toEntity(responseRoleDto));
            }

            return list;
        }
    }

    @Override
    public List<KpiFactDto> toDtoList(List<KPIFact> entity) {
        if (entity == null) {
            return null;
        } else {
            List<KpiFactDto> list = new ArrayList(entity.size());
            Iterator var3 = entity.iterator();

            while (var3.hasNext()) {
                KPIFact restaurant = (KPIFact) var3.next();
                list.add(this.toDto(restaurant));
            }

            return list;
        }
    }
}
