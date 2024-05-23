package kz.olzhas.employeeserver.mapper.kpi;

import kz.olzhas.employeeserver.dto.kpi.KpiStandardDto;
import kz.olzhas.employeeserver.mapper.Mappable;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface KpiStandardMapper extends Mappable<KpiStandard, KpiStandardDto> {
    KpiStandardMapper INSTANCE = Mappers.getMapper(KpiStandardMapper.class);
}
