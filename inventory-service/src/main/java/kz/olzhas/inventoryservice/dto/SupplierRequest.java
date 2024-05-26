package kz.olzhas.inventoryservice.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SupplierRequest {
    private Long id;

    private String name;

    private String city;

    private String email;

    private String phone;

    private String country;

    private String address;
}
