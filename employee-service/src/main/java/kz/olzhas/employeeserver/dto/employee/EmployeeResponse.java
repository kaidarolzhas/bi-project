package kz.olzhas.employeeserver.dto.employee;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class EmployeeResponse {

    private String firstName;

    private String lastName;

    private String email;

    private Long restaurantId;

    private JobRole jobRole;

    private LocalDate dateOfStart;

    private List<KPIFact> kpiFacts;

    private Double kpiMonth;

}
