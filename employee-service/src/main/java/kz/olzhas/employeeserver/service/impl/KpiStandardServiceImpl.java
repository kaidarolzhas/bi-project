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
        if(!kpiStandardCheck.isEmpty()){
            return false;
        }
        else {
            kpiStandardRepository.save(kpiStandard);
            return true;
        }
    }
}
