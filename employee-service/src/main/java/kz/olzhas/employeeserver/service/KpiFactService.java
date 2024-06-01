package kz.olzhas.employeeserver.service;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;

import java.util.List;

public interface KpiFactService {
    List<KPIFact> kpiFactsByUserId(Long userId);

    Double getKpiMonth(EmployeeRequest employeeRequest);

    Double getKpiWeak(EmployeeRequest employeeRequest);
    List<KpiStandard> getKpiStandardWeak(String role);

    void setKpiMonth(EmployeeRequest employeeRequest);
    void setKpiWeak(EmployeeRequest employeeRequest);
    Double getKpiMonthAll(Employee employee);
    void setKpiMonthAll(Long resId);
}
