package kz.olzhas.employeeserver.repository.kpi;

import kz.olzhas.employeeserver.model.kpi.KPIFact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface KpiFactRepository extends JpaRepository<KPIFact, Long> {
}
