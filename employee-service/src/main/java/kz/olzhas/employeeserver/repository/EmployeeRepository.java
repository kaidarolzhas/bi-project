package kz.olzhas.employeeserver.repository;

import kz.olzhas.employeeserver.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
