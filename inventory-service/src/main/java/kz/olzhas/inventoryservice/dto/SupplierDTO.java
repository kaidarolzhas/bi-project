package kz.olzhas.inventoryservice.dto;

import kz.olzhas.inventoryservice.dto.product.SupplierProductDTO;
import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class SupplierDTO {
    private Long id;
    private String name;
    private String city;
    private String email;
    private String phone;
    private String country;
    private String address;
    private List<SupplierProductDTO> supplierProducts;
}