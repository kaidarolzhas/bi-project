package kz.olzhas.employeeserver.service.impl;

import kz.olzhas.employeeserver.model.kpi.KPIFact;
import kz.olzhas.employeeserver.repository.kpi.KpiFactRepository;
import kz.olzhas.employeeserver.service.KpiFactService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class KpiFactServiceImpl implements KpiFactService {
    private final KpiFactRepository kpiFactRepository;

    @Override
    public List<KPIFact> kpiFactsByUserId(Long userId) {
        List<KPIFact> kpiFacts = kpiFactRepository.findAllByEmployeeId(userId);
        if (!kpiFacts.isEmpty()) {
            return kpiFacts;
        }
        return null;
    }
}
