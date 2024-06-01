package kz.olzhas.restaurantservice.repository;

import kz.olzhas.restaurantservice.model.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {
}
