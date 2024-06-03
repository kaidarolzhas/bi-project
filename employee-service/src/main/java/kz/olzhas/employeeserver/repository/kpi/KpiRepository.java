package kz.olzhas.employeeserver.repository.kpi;

import kz.olzhas.employeeserver.dto.kpi.KpiUserDto;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.kpi.Kpi;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface KpiRepository extends JpaRepository<Kpi, Long> {
    Optional<Kpi> findByEmployeeAndMonth(Employee employee , String s);

    @Query(nativeQuery = true)
    List<KpiUserDto> getKpiDataByRestaurantId(@Param("res") Long restaurantId);

    @Query(nativeQuery = true)
    List<KpiUserDto> getKpiDataByRestaurantIdRoleId(@Param("res") Long restaurantId, @Param("roleId") Long roleId);

}
