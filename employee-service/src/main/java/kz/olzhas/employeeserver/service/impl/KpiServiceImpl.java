package kz.olzhas.employeeserver.service.impl;

import kz.olzhas.employeeserver.dto.kpi.KpiUserDto;
import kz.olzhas.employeeserver.repository.kpi.KpiRepository;
import kz.olzhas.employeeserver.service.KpiService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KpiServiceImpl implements KpiService {
    private final KpiRepository kpiRepository;

    @Override
    public List<KpiUserDto> getAllByUser(Long resId) {
        return kpiRepository.getKpiDataByRestaurantId(resId);
    }

    @Override
    public List<KpiUserDto> getAllByRole(Long resId, Long role) {
        return kpiRepository.getKpiDataByRestaurantIdRoleId(resId, role);
    }
}
