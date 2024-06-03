package kz.olzhas.inventoryservice.dto.product;

import jakarta.persistence.*;
import kz.olzhas.inventoryservice.model.Order;
import kz.olzhas.inventoryservice.model.Supplier;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {
    private Long id;

    private String name;

    private double price;


    private int count;

    private String category;


    private LocalDate expirationDate;

    private Order order;
}
