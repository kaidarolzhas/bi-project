package kz.olzhas.inventoryservice.dto.product;

import kz.olzhas.inventoryservice.dto.product.ProductDto;
import kz.olzhas.inventoryservice.dto.SupplierDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierProductDTO {
    private Long id;
    private SupplierDTO supplier;
    private ProductDto product;
    private double price;
    private int count;
}
