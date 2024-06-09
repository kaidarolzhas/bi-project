package kz.olzhas.inventoryservice.mapper.SupplierMapper;


import kz.olzhas.inventoryservice.dto.OrderProductDTO;
import kz.olzhas.inventoryservice.mapper.Mappable;
import kz.olzhas.inventoryservice.model.OrderProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderProductMapper extends Mappable<OrderProduct, OrderProductDTO> {
}
