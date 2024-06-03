package kz.olzhas.inventoryservice.service;

import kz.olzhas.inventoryservice.dto.OrderDto;
import kz.olzhas.inventoryservice.dto.product.ProductDto;
import kz.olzhas.inventoryservice.model.Order;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAll();

    void save(OrderDto productDto);

    void update(Long id, OrderDto productDto);

    void deleteById(Long id);
}
