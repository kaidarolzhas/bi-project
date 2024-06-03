package kz.olzhas.employeeserver.service.impl;

import kz.olzhas.employeeserver.dto.employee.EmployeeRequest;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import kz.olzhas.employeeserver.model.kpi.Kpi;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import kz.olzhas.employeeserver.repository.employee.EmployeeRepository;
import kz.olzhas.employeeserver.repository.kpi.KpiFactRepository;
import kz.olzhas.employeeserver.repository.kpi.KpiRepository;
import kz.olzhas.employeeserver.service.JobRoleService;
import kz.olzhas.employeeserver.service.KpiFactService;
import kz.olzhas.employeeserver.service.KpiStandardService;
import lombok.RequiredArgsConstructor;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class KpiFactServiceImpl implements KpiFactService {
    private final KpiFactRepository kpiFactRepository;
    private final EmployeeRepository employeeRepository;
    private final KpiStandardService kpiStandardService;
    private final KpiRepository kpiRepository;

    @Override
    public List<KPIFact> kpiFactsByUserId(Long userId) {
        List<KPIFact> kpiFacts = kpiFactRepository.findAllByEmployeeId(userId);
        if (!kpiFacts.isEmpty()) {
            return kpiFacts;
        }
        return null;
    }


    @Override
    public Double getKpiMonth(String role, List<KPIFact> kpiFacts) {
        List<KpiStandard> kpiStandardList = kpiStandardService.getAllByRole(role);
        double sum = 0;
        //(fact/norm)*percent
        for (KpiStandard kpiStandard : kpiStandardList){
            for (KPIFact kpiFact : kpiFacts){
                if(Objects.equals(kpiFact.getName(), kpiStandard.getName())){
                    sum += (kpiFact.getValue()/kpiStandard.getValue())* kpiStandard.getPercent();
                }
            }
        }
        return sum;
    }

    @Override
    public Double getKpiMonthAll(String role, List<KPIFact> kpiFacts) {
        List<KpiStandard> kpiStandardList = kpiStandardService.getAllByRole(role);
        double sum = 0;
        //(fact/norm)*percent
        for (KpiStandard kpiStandard : kpiStandardList){
            for (KPIFact kpiFact : kpiFacts){
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

    private String getCurrentYear() {
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy");
        return now.format(formatter);
    }

    @Override
    public void setKpiMonth(EmployeeRequest employeeRequest) {
        Optional<Employee> employee = employeeRepository.findById(employeeRequest.getId());
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM", Locale.ENGLISH);
        String month = now.format(formatter).toLowerCase();
        if(employee.isPresent()){
            List<KPIFact> kpiFacts = kpiFactRepository.findAllByEmployeeIdAndMonthAndYear(employee.get().getId(), month, getCurrentYear());
            double totalKpi = getKpiMonth(employee.get().getJobRole().getRole(),kpiFacts);
            employee.get().setKpiMonth(getKpiMonth(employee.get().getJobRole().getRole(),kpiFacts));
            employeeRepository.saveAndFlush(employee.get());
            Optional<Kpi> kpi = kpiRepository.findByEmployeeAndMonth(employee.get(), month);
            if (kpi.isPresent()) {
                kpi.get().setKpi(totalKpi);
                kpiRepository.saveAndFlush(kpi.get());
            } else {
                Kpi kpi2 = Kpi.builder()
                        .kpi(totalKpi)
                        .year(getCurrentYear())
                        .month(month)
                        .employee(employee.get())
                        .build();
                kpiRepository.saveAndFlush(kpi2);
            }
        }

    }

//    public void setKpiMonthByMonthAndYear(String month, String year) {
//        List<Employee> employees = employeeRepository.findAll();
//
//        for (Employee employee : employees) {
//            List<KPIFact> kpiFacts = kpiFactRepository.findAllByEmployeeIdAndMonthAndYear(employee.getId(), month, year);
//            if (!kpiFacts.isEmpty()) {
//                double kpiSum = calculateKpi(kpiStandardService.getAllByRole(employee.getJobRole().getRole()), kpiFacts);
//                employee.setKpiMonth(kpiSum);
//                employeeRepository.saveAndFlush(employee);
//            }
//        }
//    }

    @Override
    public void setKpiMonthAll(Long resId) {
        List<Employee> employeeList = employeeRepository.findAllByRestaurantId(resId);

        for (Employee employee : employeeList) {
            List<KPIFact> kpiFacts = kpiFactRepository.findAllByEmployeeId(employee.getId());
            Month[] months = Month.values();
            String[] monthNames = Arrays.stream(months)
                    .map(month -> month.name().toLowerCase())
                    .toArray(String[]::new);
            List<KPIFact> kpiFactsMonth = new ArrayList<>();
            for (String monthh : monthNames) {

                for (KPIFact kpiFact : kpiFacts) {
                    if (kpiFact.getMonth().equals(monthh)) {
                        kpiFactsMonth.add(kpiFact);
                    }
                }
                if (!kpiFactsMonth.isEmpty()) {
                    double totalKpi = getKpiMonth(employee.getJobRole().getRole(), kpiFactsMonth);
                    Optional<Kpi> kpi = kpiRepository.findByEmployeeAndMonth(employee, monthh);
                    if (kpi.isPresent()) {
                        kpi.get().setKpi(totalKpi);
                        kpiRepository.saveAndFlush(kpi.get());
                    } else {
                        Kpi kpi2 = Kpi.builder()
                                .kpi(totalKpi)
                                .year(getCurrentYear())
                                .month(monthh)
                                .employee(employee)
                                .build();
                        kpiRepository.saveAndFlush(kpi2);
                    }
                    kpiFactsMonth.clear();
                }

            }
        }
    }

    @Override
    public List<KPIFact> getKpiByMonthAndYear(String month, String year) {
        return kpiFactRepository.findAllByMonthAndYear(month, year);
    }

    @Override
    public boolean save(KPIFact kpiFact, Long empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        if (employee.isPresent()){
            kpiFact.setEmployee(employee.get());
            kpiFactRepository.saveAndFlush(kpiFact);
            return  true;
        }
        return false;
    }

    @Override
    public boolean update(KPIFact kpiFact, Long empId) {
        Optional<Employee> employee = employeeRepository.findById(empId);
        Optional<KPIFact> kpiFactEx = kpiFactRepository.findById(kpiFact.getId());
        if (employee.isPresent()){

            if(kpiFactEx.isPresent()){
                kpiFactEx.get().setYear(kpiFact.getYear());
                kpiFactEx.get().setMonth(kpiFact.getMonth());
                kpiFactEx.get().setName(kpiFact.getName());
                kpiFactEx.get().setPercent(kpiFact.getPercent());
                kpiFactEx.get().setValue(kpiFact.getValue());
                kpiFactEx.get().setEmployee(employee.get());
                kpiFactRepository.saveAndFlush(kpiFactEx.get());
                return  true;
            }
        }
        return false;
    }

    @Override
    public void delete(Long id) {
        kpiFactRepository.deleteById(id);
    }


}
