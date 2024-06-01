package kz.olzhas.restaurantservice.service;


import kz.olzhas.restaurantservice.model.Expenses;
import kz.olzhas.restaurantservice.model.Salary;

import java.util.List;

public interface SalaryService {
    List<Salary> getSalary(Long id, Expenses expenses);
}
