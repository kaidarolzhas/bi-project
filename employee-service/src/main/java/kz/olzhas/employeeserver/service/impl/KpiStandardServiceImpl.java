package kz.olzhas.employeeserver.service.impl;


import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import kz.olzhas.employeeserver.repository.kpi.KpiStandardRepository;
import kz.olzhas.employeeserver.service.JobRoleService;
import kz.olzhas.employeeserver.service.KpiStandardService;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KpiStandardServiceImpl implements KpiStandardService {
    private final KpiStandardRepository kpiStandardRepository;
    private final JobRoleService jobRoleService;

    @Override
    public List<KpiStandard> getAllByRole(String job) {
        return kpiStandardRepository.findAllByJobRoleRole(job);
    }

    @Override
    public List<KpiStandard> getAll() {
        return kpiStandardRepository.findAll();
    }

    @Override
    public void updateKPI(KpiStandard kpiStandard) throws BadRequestException {
        Optional<KpiStandard> KpiStandard = kpiStandardRepository.findById(kpiStandard.getId());

        KpiStandard existingKpi = KpiStandard.orElseThrow(() -> new BadRequestException("Job role not found"));
        existingKpi.setValue(kpiStandard.getValue());
        existingKpi.setName(kpiStandard.getName());
        existingKpi.setJobRole(kpiStandard.getJobRole());

        kpiStandardRepository.save(existingKpi);
    }

    @Override
    public void deleteKpi(Long id) {
        kpiStandardRepository.deleteById(id);
    }

    @Override
    public boolean save(KpiStandard kpiStandard, Long resId) throws BadRequestException {
        Optional<JobRole> jobRole = jobRoleService.getByRole(kpiStandard.getJobRole().getRole(), resId);
        JobRole exJobRole = jobRole.orElseThrow(() -> new BadRequestException("Job role not found"));
        List<KpiStandard> kpiStandardCheck = kpiStandardRepository.findAllByJobRoleId(exJobRole.getId());
        Double sum = 0.0;
        for(KpiStandard kpiStandard1 :kpiStandardCheck){
            sum+=kpiStandard1.getPercent();
        }
        if(sum>1){
            return false;
        }
        else {
            kpiStandardRepository.save(kpiStandard);
            return true;
        }
    }
}
