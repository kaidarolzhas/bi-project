package kz.olzhas.inventoryservice.service.impl;

import kz.olzhas.inventoryservice.dto.OrderDto;
import kz.olzhas.inventoryservice.dto.OrderProductDTO;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.OrderMapper;
import kz.olzhas.inventoryservice.mapper.SupplierMapper.OrderProductMapper;
import kz.olzhas.inventoryservice.model.Order;
import kz.olzhas.inventoryservice.model.OrderProduct;
import kz.olzhas.inventoryservice.model.SupplierProduct;
import kz.olzhas.inventoryservice.repository.OrderProductRepository;
import kz.olzhas.inventoryservice.repository.OrderRepository;
import kz.olzhas.inventoryservice.repository.SupplierProductRepository;
import kz.olzhas.inventoryservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final OrderProductMapper orderProductMapper;
    private final OrderProductRepository orderProductRepository;
    private final SupplierProductRepository supplierProductRepository;
    @Override
    public List<OrderDto> getAll(Long resId) {
        List<Order> order = orderRepository.findAllByResId(resId);
        return orderMapper.toDtoList(order);
    }

    @Override
    public void save(OrderDto orderDto) {
        int count = 0;
        double price = 0;
        Optional<SupplierProduct> supplierProduct = Optional.of(new SupplierProduct());
        for(OrderProductDTO orderProductDTO :orderDto.getOrderProducts()){
            count+=orderProductDTO.getCount();
            orderProductDTO.setOrder_id(orderDto.getId());
            supplierProduct =supplierProductRepository.findById(orderProductDTO.getSupplierProduct().getId());
            if(supplierProduct.isPresent()){
                price+=orderProductDTO.getCount()*supplierProduct.get().getPrice();
            }
        }
        orderDto.setTotalCount(count);
        orderDto.setTotalPrice(price);
        Order order = orderMapper.toEntity(orderDto);
        if(!orderRepository.existsById(order.getId())){
            orderRepository.saveAndFlush(order);
        }
    }

    public void update(Long id, OrderDto orderDto) {
//        Optional<Order> orderOptional = orderRepository.findById(id);
//        if (orderOptional.isPresent()) {
//            Order order = orderOptional.get();
//            order.setTotalCount(orderDto.getTotalCount());
//            order.setStatus(orderDto.getStatus());
//            order.setResId(orderDto.getResId());
//            order.setName(orderDto.getName());
//            order.setTotalPrice(orderDto.getTotalPrice());
//            order.setArrive(orderDto.getArrive());
//           List<OrderProduct> orderProductList = orderProductMapper.toEntityList(orderDto.getOrderProducts());
//           orderProductRepository.saveAndFlush(orderProductList);
//
//           for(OrderProduct orderProduct : orderProductList){
//                order
//           }
//
//            orderRepository.saveAndFlush(order);
//        }
    }


    @Override
    public void deleteById(Long id) {
        orderRepository.deleteById(id);
    }

    @Override
    public OrderDto getById(Long id) {
        Optional<Order> orderOptional = orderRepository.findById(id);
        return orderOptional.map(orderMapper::toDto).orElse(null);
    }
}
