package kz.olzhas.employeeserver.service;

import kz.olzhas.employeeserver.model.kpi.KpiStandard;

import java.util.List;

public interface KpiStandardService {

    List<KpiStandard> getAllByRole(String job);

    List<KpiStandard> getAll();

    boolean save(KpiStandard kpiStandard);
}
