package kz.olzhas.inventoryservice.dto.product;

import kz.olzhas.inventoryservice.dto.product.SupplierProductDTO;
import lombok.*;
import kz.olzhas.inventoryservice.model.ProductCategory;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;
    private String name;
    private ProductCategory category;
    private LocalDate expirationDate;
}
