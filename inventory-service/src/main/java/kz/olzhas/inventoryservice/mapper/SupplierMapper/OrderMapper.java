package kz.olzhas.inventoryservice.mapper.SupplierMapper;

import kz.olzhas.inventoryservice.dto.OrderDto;
import kz.olzhas.inventoryservice.dto.product.ProductDto;
import kz.olzhas.inventoryservice.mapper.Mappable;
import kz.olzhas.inventoryservice.model.Order;
import kz.olzhas.inventoryservice.model.Product;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = "spring")
public class OrderMapper implements Mappable<Order, OrderDto> {
    @Override
    public Order toEntity(OrderDto dto) {
        if (dto == null) {
            return null;
        }

        return Order.builder()
                .id(dto.getId())  // Id should typically be generated by the database, not set here
                .name(dto.getName())
                .price(dto.getPrice())
                .totalPrice(dto.getTotalPrice())
                .totalCount(dto.getTotalCount())
                .deliver(dto.getDeliver())
                .arrive(dto.getArrive())
                .supplier(dto.getSupplier())
                .productList(dto.getProductList())
                .build();
    }

    @Override
    public OrderDto toDto(Order entity) {
        if (entity == null) {
            return null;
        }

        return OrderDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .price(entity.getPrice())
                .totalPrice(entity.getTotalPrice())
                .totalCount(entity.getTotalCount())
                .deliver(entity.getDeliver())
                .arrive(entity.getArrive())
                .supplier(entity.getSupplier())
                .productList(entity.getProductList())
                .build();

    }

    @Override
    public List<Order> toEntityList(List<OrderDto> dto) {
        if (dto == null) {
            return null;
        } else {
            List<Order> list = new ArrayList(dto.size());
            Iterator var3 = dto.iterator();

            while(var3.hasNext()) {
                OrderDto employeeRequest = (OrderDto)var3.next();
                list.add(this.toEntity(employeeRequest));
            }

            return list;
        }
    }

    @Override
    public List<OrderDto> toDtoList(List<Order> entity) {
         if (entity == null) {
            return null;
        } else {
            List<OrderDto> list = new ArrayList(entity.size());
            Iterator var3 = entity.iterator();

            while(var3.hasNext()) {
                Order restaurant = (Order)var3.next();
                list.add(this.toDto(restaurant));
            }

            return list;
        }
    }
}