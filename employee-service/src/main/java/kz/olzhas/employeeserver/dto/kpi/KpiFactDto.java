package kz.olzhas.employeeserver.dto.kpi;

import kz.olzhas.employeeserver.model.employee.JobRole;
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
    private JobRole role;
}
