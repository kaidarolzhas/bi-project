package kz.olzhas.inventoryservice.repository;

import kz.olzhas.inventoryservice.model.SupplierProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierProductRepository extends JpaRepository<SupplierProduct, Long> {
}
