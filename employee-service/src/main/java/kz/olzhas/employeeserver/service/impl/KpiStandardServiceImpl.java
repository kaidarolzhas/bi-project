package kz.olzhas.employeeserver.service.impl;


import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import kz.olzhas.employeeserver.repository.kpi.KpiStandardRepository;
import kz.olzhas.employeeserver.service.KpiStandardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KpiStandardServiceImpl implements KpiStandardService {
    private final KpiStandardRepository kpiStandardRepository;


    @Override
    public List<KpiStandard> getAllByRole(String job) {
        return kpiStandardRepository.findAllByJobRoleRole(job);
    }

    @Override
    public List<KpiStandard> getAll() {
        return kpiStandardRepository.findAll();
    }

    @Override
    public boolean save(KpiStandard kpiStandard) {
        List<KpiStandard> kpiStandardCheck = kpiStandardRepository.findAllByJobRoleId(kpiStandard.getJobRole().getId());
        Double sum = 0.0;
        for(KpiStandard kpiStandard1 :kpiStandardCheck){
            sum+=kpiStandard1.getPercent();
        }
        if(sum>=1){
            return false;
        }
        else {
            kpiStandardRepository.save(kpiStandard);
            return true;
        }
    }
}
