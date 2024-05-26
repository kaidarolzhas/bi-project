package kz.olzhas.inventoryservice.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierResponse {

    private String name;

    private String city;

    private String email;

    private String phone;

    private String country;

    private String address;
}
