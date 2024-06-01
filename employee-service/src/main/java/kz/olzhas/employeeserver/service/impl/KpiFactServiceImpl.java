package kz.olzhas.employeeserver.service.impl;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import kz.olzhas.employeeserver.repository.employee.EmployeeRepository;
import kz.olzhas.employeeserver.repository.kpi.KpiFactRepository;
import kz.olzhas.employeeserver.service.JobRoleService;
import kz.olzhas.employeeserver.service.KpiFactService;
import kz.olzhas.employeeserver.service.KpiStandardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class KpiFactServiceImpl implements KpiFactService {
    private final KpiFactRepository kpiFactRepository;
    private final EmployeeRepository employeeRepository;
    private final JobRoleService jobRoleService;
    private final KpiStandardService kpiStandardService;

    @Override
    public List<KPIFact> kpiFactsByUserId(Long userId) {
        List<KPIFact> kpiFacts = kpiFactRepository.findAllByEmployeeId(userId);
        if (!kpiFacts.isEmpty()) {
            return kpiFacts;
        }
        return null;
    }


    @Override
    public Double getKpiMonth(EmployeeRequest employeeRequest) {
        String role = employeeRequest.getJobRole().getRole();
        List<KpiStandard> kpiStandardList = kpiStandardService.getAllByRole(role);
        List<KPIFact> kpiFactList = kpiFactRepository.findAllByEmployeeId(employeeRequest.getId());
        double sum = 0;
        //(fact/norm)*percent
        for (KpiStandard kpiStandard : kpiStandardList){
            for (KPIFact kpiFact : kpiFactList){
                if(Objects.equals(kpiFact.getName(), kpiStandard.getName())){
                    sum += (kpiFact.getValue()/kpiStandard.getValue())* kpiStandard.getPercent();
                }
            }
        }
        return sum;
    }

    @Override
    public Double getKpiMonthAll(Employee employee) {
        String role = employee.getJobRole().getRole();
        List<KpiStandard> kpiStandardList = kpiStandardService.getAllByRole(role);
        List<KPIFact> kpiFactList = kpiFactRepository.findAllByEmployeeId(employee.getId());
        double sum = 0;
        //(fact/norm)*percent
        for (KpiStandard kpiStandard : kpiStandardList){
            for (KPIFact kpiFact : kpiFactList){
                if(Objects.equals(kpiFact.getName(), kpiStandard.getName())){
                    sum += (kpiFact.getValue()/kpiStandard.getValue())* kpiStandard.getPercent();
                }
            }
        }
        return sum;
    }

    @Override
    public Double getKpiWeak(EmployeeRequest employeeRequest) {
        String role = employeeRequest.getJobRole().getRole();
        List<KpiStandard> kpiStandardList = getKpiStandardWeak(role);
        List<KPIFact> kpiFactList = kpiFactRepository.findAllByEmployeeId(employeeRequest.getId());
        double sum = 0;
        //(fact/norm)*percent
        for (KpiStandard kpiStandard : kpiStandardList){
            for (KPIFact kpiFact : kpiFactList){
                if(Objects.equals(kpiFact.getName(), kpiStandard.getName())){
                    sum += (kpiFact.getValue()/kpiStandard.getValue())* kpiStandard.getPercent();
                }
            }
        }
        return sum;
    }

    @Override
    public List<KpiStandard> getKpiStandardWeak(String role) {
        List<KpiStandard> kpiStandardList = kpiStandardService.getAllByRole(role);
        for (KpiStandard kpiStand : kpiStandardList){
            kpiStand.setValue((kpiStand.getValue()*5)/24);
        }
        return kpiStandardList;
    }

    @Override
    public void setKpiMonth(EmployeeRequest employeeRequest) {
        Optional<Employee> employee = employeeRepository.findById(employeeRequest.getId());
        if(employee.isPresent()){
            employee.get().setKpiMonth(getKpiMonth(employeeRequest));
            employeeRepository.saveAndFlush(employee.get());
        }
    }

    @Override
    public void setKpiMonthAll(Long resId) {
        List<Employee> employeeList = employeeRepository.findAllByRestaurantId(resId);
        for (Employee employee :employeeList){
            employee.setKpiMonth(getKpiMonthAll(employee));
            employeeRepository.saveAndFlush(employee);
        }
    }

    @Override
    public void setKpiWeak(EmployeeRequest employeeRequest) {
        Optional<Employee> employee = employeeRepository.findById(employeeRequest.getId());
        if(employee.isPresent()){
            employee.get().setKpiWeak(getKpiWeak(employeeRequest));
            employeeRepository.saveAndFlush(employee.get());
        }
    }

}
