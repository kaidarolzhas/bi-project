package kz.olzhas.inventoryservice.service;

import kz.olzhas.inventoryservice.dto.OrderProductDTO;

import java.util.List;

public interface OrderProductService {
    void save(OrderProductDTO orderProductDTO);
    void update(Long id, OrderProductDTO orderProductDTO);
    void deleteById(Long id);
    List<OrderProductDTO> getAll();
    OrderProductDTO getById(Long id);
}
