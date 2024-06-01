package kz.olzhas.restaurantservice.dto;

import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeRequest {

    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private Long restaurantId;

    private JobDto jobRole;

    private LocalDate dateOfStart;

    private List<KpiFactDto> kpiFacts;

    private Double kpiMonth;



}
