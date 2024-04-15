package kz.olzhas.employeeserver.service;

import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.kpi.KPIFact;

import java.util.List;

public interface KpiFactService {
    List<KPIFact> kpiFactsByUserId(Long userId);
}
