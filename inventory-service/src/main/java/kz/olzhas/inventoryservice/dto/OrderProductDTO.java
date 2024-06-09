package kz.olzhas.inventoryservice.dto;

import kz.olzhas.inventoryservice.dto.product.SupplierProductDTO;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderProductDTO {
    private Long id;
    private Long orderId;
    private SupplierProductDTO supplierProduct;
    private int count;
}
