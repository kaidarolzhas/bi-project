package kz.olzhas.employeeserver.dto.kpi;

import jakarta.persistence.Column;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.employee.JobRole;
import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class KpiFactDto {
    private Long id;
    private String name;
    private Double value;
    private Double percent;
    private JobRole role;
    private String year;
    private Long empId;
    private String month;
}
