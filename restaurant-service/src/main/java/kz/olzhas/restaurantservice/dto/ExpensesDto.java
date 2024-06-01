package kz.olzhas.restaurantservice.dto;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpensesDto {
    private BigDecimal electricity;
    private BigDecimal rent;
    private Date startDate;
    private Date endDate;
}
