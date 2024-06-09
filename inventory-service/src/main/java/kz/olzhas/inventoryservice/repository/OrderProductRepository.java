package kz.olzhas.inventoryservice.repository;

import kz.olzhas.inventoryservice.model.OrderProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {
    List<OrderProduct> getAllByOrder_id(Long id);
}
