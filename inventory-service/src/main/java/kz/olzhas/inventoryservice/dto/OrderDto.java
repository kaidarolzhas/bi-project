package kz.olzhas.inventoryservice.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDto {
    private Long id;
    private String name;
    private String status;
    private String address;
    private double totalPrice;
    private int totalCount;
    private LocalDate arrive;
    private Long resId;
    private List<OrderProductDTO> orderProducts;
}
