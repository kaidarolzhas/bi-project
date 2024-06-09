package kz.olzhas.inventoryservice.repository;

import kz.olzhas.inventoryservice.model.Order;
import kz.olzhas.inventoryservice.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
