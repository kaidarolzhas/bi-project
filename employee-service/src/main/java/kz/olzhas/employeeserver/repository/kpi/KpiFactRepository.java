package kz.olzhas.employeeserver.repository.kpi;

import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KpiFactRepository extends JpaRepository<KPIFact, Long> {
    List<KPIFact> findAllByEmployeeId(Long userId);
    List<KPIFact> findAllByMonthAndYear(String month, String year);

    List<KPIFact> findAllByEmployeeIdAndMonthAndYear(Long id, String month, String year);
    boolean existsByNameAndEmployee(String name, Employee employee);
}
