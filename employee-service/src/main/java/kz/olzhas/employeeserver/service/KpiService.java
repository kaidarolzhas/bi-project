package kz.olzhas.employeeserver.service;

import kz.olzhas.employeeserver.dto.kpi.KpiUserDto;

import java.util.List;

public interface KpiService {
    List<KpiUserDto> getAllByUser(Long resId);
}
