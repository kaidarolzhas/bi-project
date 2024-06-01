package kz.olzhas.restaurantservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class JobDto {
    private Long id;
    private Double oklad;
    private Double bonus;
    private String role;
    private Long restaurantId;
}