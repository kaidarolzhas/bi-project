package kz.olzhas.employeeserver.repository.employee;

import kz.olzhas.employeeserver.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByJobRoleId(Long id);
}
