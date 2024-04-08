package kz.olzhas.employeeserver.repository.employee;

import kz.olzhas.employeeserver.model.employee.JobRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobRoleRepository extends JpaRepository<JobRole, Long> {
    Optional<JobRole> findByRole(String role);
}
