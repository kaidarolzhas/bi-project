package kz.olzhas.inventoryservice.service.impl;

import kz.olzhas.inventoryservice.dto.OrderDto;
import kz.olzhas.inventoryservice.dto.product.ProductDto;
import kz.olzhas.inventoryservice.repository.OrderRepository;
import kz.olzhas.inventoryservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    @Override
    public List<OrderDto> getAll() {
        return null;
    }

    @Override
    public void save(OrderDto productDto) {

    }

    @Override
    public void update(Long id, OrderDto productDto) {

    }

    @Override
    public void deleteById(Long id) {

    }
}
