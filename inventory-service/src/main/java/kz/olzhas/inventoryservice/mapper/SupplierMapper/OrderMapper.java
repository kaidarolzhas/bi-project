package kz.olzhas.inventoryservice.mapper.SupplierMapper;

import kz.olzhas.inventoryservice.dto.OrderDto;
import kz.olzhas.inventoryservice.mapper.Mappable;
import kz.olzhas.inventoryservice.model.Order;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface OrderMapper extends Mappable<Order, OrderDto> {

}
