package kz.olzhas.employeeserver.service;

import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface KpiStandardService {

    List<KpiStandard> getAllByRole(String job);

    List<KpiStandard> getAll();

    boolean save(KpiStandard kpiStandard, Long resId) throws BadRequestException;

    void updateKPI(KpiStandard kpiStandard) throws BadRequestException;

    void deleteKpi(Long id);
}
