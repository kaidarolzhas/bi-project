package kz.olzhas.restaurantservice.repository;

import kz.olzhas.restaurantservice.model.CustomExpenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomExpensesRepository extends JpaRepository<CustomExpenses, Long> {
}
