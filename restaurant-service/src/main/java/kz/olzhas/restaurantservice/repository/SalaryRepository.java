package kz.olzhas.restaurantservice.repository;

import kz.olzhas.restaurantservice.model.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary, Long> {


}
