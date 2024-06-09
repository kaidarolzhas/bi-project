package kz.olzhas.inventoryservice.service;

import kz.olzhas.inventoryservice.dto.OrderDto;

import java.util.List;

public interface OrderService {
    List<OrderDto> getAll(Long resId);

    void save(OrderDto productDto);

    void update(Long id, OrderDto productDto);

    void deleteById(Long id);

    OrderDto getById(Long id);
}
