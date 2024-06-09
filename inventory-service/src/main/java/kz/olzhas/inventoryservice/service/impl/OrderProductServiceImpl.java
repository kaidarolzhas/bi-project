package kz.olzhas.inventoryservice.service.impl;

import kz.olzhas.inventoryservice.dto.OrderProductDTO;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.OrderMapper;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.OrderProductMapper;
import kz.olzhas.inventoryservice.model.Order;
import kz.olzhas.inventoryservice.model.OrderProduct;
import kz.olzhas.inventoryservice.repository.OrderProductRepository;
import kz.olzhas.inventoryservice.repository.OrderRepository;
import kz.olzhas.inventoryservice.repository.SupplierProductRepository;
import kz.olzhas.inventoryservice.service.OrderProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderProductServiceImpl implements OrderProductService {
    private final OrderProductRepository orderProductRepository;
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final SupplierProductRepository supplierProductRepository;
    private final OrderProductMapper orderProductMapper;

    @Override
    public void save(OrderProductDTO orderProductDTO) {
        OrderProduct orderProduct = orderProductMapper.toEntity(orderProductDTO);
        orderProductRepository.saveAndFlush(orderProduct);
    }

    @Override
    public void update(Long id, OrderProductDTO orderProductDTO) {
//        Optional<OrderProduct> orderProductOptional = orderProductRepository.findById(id);
//        if (orderProductOptional.isPresent()) {
//            OrderProduct orderProduct = orderProductOptional.get();
//            orderProduct.setCount(orderProductDTO.getCount());
//            Order order = orderMapper.toEntity(orderProductDTO.getOrder());
//            // Update the order reference
//            orderProduct.setOrder(order);
//
//            // Update the supplier product reference
//            orderProduct.setSupplierProduct(supplierProductRepository.findById(orderProductDTO.getSupplierProduct().getId()).orElse(null));
//
//            orderProductRepository.saveAndFlush(orderProduct);
//        }
    }

    @Override
    public void deleteById(Long id) {
        orderProductRepository.deleteById(id);
    }

    @Override
    public List<OrderProductDTO> getAll() {
        return orderProductMapper.toDtoList(orderProductRepository.findAll());
    }

    @Override
    public OrderProductDTO getById(Long id) {
        Optional<OrderProduct> orderProductOptional = orderProductRepository.findById(id);
        return orderProductOptional.map(orderProductMapper::toDto).orElse(null);
    }
}
