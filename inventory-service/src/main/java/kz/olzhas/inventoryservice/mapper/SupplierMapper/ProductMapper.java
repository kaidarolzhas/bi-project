package kz.olzhas.inventoryservice.mapper.SupplierMapper;

import kz.olzhas.inventoryservice.dto.product.ProductDto;
import kz.olzhas.inventoryservice.mapper.Mappable;
import kz.olzhas.inventoryservice.model.Product;
import org.mapstruct.Mapper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Mapper(componentModel = "spring")
public class ProductMapper implements Mappable<Product, ProductDto> {
    @Override
    public Product toEntity(ProductDto dto) {
        return Product.builder()
                .id(dto.getId())
                .category(dto.getCategory())
                .count(dto.getCount())
                .expirationDate(dto.getExpirationDate())
                .order(dto.getOrder())
                .price(dto.getPrice())
                .build();
    }

    @Override
    public ProductDto toDto(Product entity) {
        return ProductDto.builder()
                .id(entity.getId())
                .category(entity.getCategory())
                .count(entity.getCount())
                .expirationDate(entity.getExpirationDate())
                .order(entity.getOrder())
                .price(entity.getPrice())
                .build();
    }

    @Override
    public List<Product> toEntityList(List<ProductDto> dto) {
        if (dto == null) {
            return null;
        } else {
            List<Product> list = new ArrayList(dto.size());
            Iterator var3 = dto.iterator();

            while(var3.hasNext()) {
                ProductDto employeeRequest = (ProductDto)var3.next();
                list.add(this.toEntity(employeeRequest));
            }

            return list;
        }
    }

    @Override
    public List<ProductDto> toDtoList(List<Product> entity) {
        if (entity == null) {
            return null;
        } else {
            List<ProductDto> list = new ArrayList(entity.size());
            Iterator var3 = entity.iterator();

            while(var3.hasNext()) {
                Product restaurant = (Product)var3.next();
                list.add(this.toDto(restaurant));
            }

            return list;
        }
    }
}
