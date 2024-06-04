package kz.olzhas.inventoryservice.dto;


import jakarta.persistence.*;
import kz.olzhas.inventoryservice.model.Product;
import kz.olzhas.inventoryservice.model.Supplier;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {

    private Long id;

    private String name;

    private double price;

    private double totalPrice;

    private int totalCount;

    private LocalDate arrive;

     private Supplier supplier;

    private List<Product> productList;
}
