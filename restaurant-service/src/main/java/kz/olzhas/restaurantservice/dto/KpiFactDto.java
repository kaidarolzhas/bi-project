package kz.olzhas.restaurantservice.dto;


import lombok.*;
@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KpiFactDto {
    private String name;
    private Double value;
    private Double percent;
}
