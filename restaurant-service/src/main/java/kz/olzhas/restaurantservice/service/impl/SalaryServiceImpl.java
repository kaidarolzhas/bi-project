package kz.olzhas.restaurantservice.service.impl;

import kz.olzhas.restaurantservice.dto.EmployeeRequest;
import kz.olzhas.restaurantservice.dto.JobDto;
import kz.olzhas.restaurantservice.feign.EmployeeClient;
import kz.olzhas.restaurantservice.model.Expenses;
import kz.olzhas.restaurantservice.model.Salary;
import kz.olzhas.restaurantservice.repository.SalaryRepository;
import kz.olzhas.restaurantservice.service.SalaryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SalaryServiceImpl implements SalaryService {
    private final EmployeeClient employeeClient;
    private final SalaryRepository salaryRepository;
    @Override
    public List<Salary> getSalary(Long resId, Expenses expenses) {
        List<JobDto> jobDtoList = employeeClient.getRoles(resId);
        List<EmployeeRequest> employeeRequestList = employeeClient.getEmployees(resId);
        List<Salary> salaryList = new ArrayList<>();
        for (JobDto jobDto : jobDtoList){
            for(EmployeeRequest employeeRequest : employeeRequestList){
                double empSalary = calculateSalary(employeeRequest);
                Salary salary = Salary.builder()
                        .employeeId(employeeRequest.getId())
                        .EmployeeRole(jobDto.getRole())
                        .expenses(expenses)
                        .salary(empSalary)
                        .build();
                salaryList.add(salary);
            }
        }
        salaryRepository.saveAllAndFlush(salaryList);
        return salaryList;
    }

    private double calculateSalary(EmployeeRequest employeeRequest){
        double salary = 0;
        double oklad = employeeRequest.getJobRole().getOklad();
        double bonus = employeeRequest.getJobRole().getBonus();
        double kpi = employeeRequest.getKpiMonth();
        salary = oklad*kpi;
        return salary;
    }
}
