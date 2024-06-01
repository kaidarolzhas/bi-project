package kz.olzhas.employeeserver.repository.employee;

import kz.olzhas.employeeserver.model.employee.JobRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface JobRoleRepository extends JpaRepository<JobRole, Long> {
    Optional<JobRole> findByRoleAndRestaurantId(String role, Long restaurantId);
    List<JobRole> findAllByRestaurantId(Long id);
    Optional<JobRole> findJobRoleByRestaurantId(Long id);
}
