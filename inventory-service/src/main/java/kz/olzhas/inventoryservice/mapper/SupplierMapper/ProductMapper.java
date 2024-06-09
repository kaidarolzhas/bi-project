package kz.olzhas.inventoryservice.mapper.SupplierMapper;

import kz.olzhas.inventoryservice.dto.product.ProductDto;
import kz.olzhas.inventoryservice.mapper.Mappable;
import kz.olzhas.inventoryservice.model.Product;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper extends Mappable<Product, ProductDto> {


}
