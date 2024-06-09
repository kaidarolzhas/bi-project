package kz.olzhas.inventoryservice.mapper.SupplierMapper;


import kz.olzhas.inventoryservice.dto.product.SupplierProductDTO;
import kz.olzhas.inventoryservice.mapper.Mappable;
import kz.olzhas.inventoryservice.model.SupplierProduct;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SupplierProductDtoMapper extends Mappable<SupplierProduct, SupplierProductDTO> {
}
