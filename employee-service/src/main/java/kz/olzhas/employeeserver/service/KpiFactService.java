package kz.olzhas.employeeserver.service;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;

import java.util.List;

public interface KpiFactService {
    List<KPIFact> kpiFactsByUserId(Long userId);

    Double getKpiMonth(String role, List<KPIFact> kpiFact);

    Double getKpiWeak(EmployeeRequest employeeRequest);
    List<KpiStandard> getKpiStandardWeak(String role);

    void setKpiMonth(EmployeeRequest employeeRequest);
    Double getKpiMonthAll(String role, List<KPIFact> kpiFacts);

        void setKpiMonthAll(Long resId);

    boolean update(KPIFact kpiFact, Long empId);
    void delete(Long id);
    List<KPIFact> getKpiByMonthAndYear(String month, String year);

    boolean save(KPIFact kpiFact, Long empId);
}
