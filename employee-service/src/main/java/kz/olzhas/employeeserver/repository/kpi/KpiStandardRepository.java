package kz.olzhas.employeeserver.repository.kpi;

import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KpiStandardRepository extends JpaRepository<KpiStandard, Long> {
    List<KpiStandard> findAllByJobRoleId(Long id);
    List<KpiStandard> findAllByJobRoleRole(String job);
    List<KpiStandard> findAllByJobRole(JobRole job);
    boolean existsByJobRoleRole(String role);

}
