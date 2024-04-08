package kz.olzhas.employeeserver.dto.employee;

import kz.olzhas.employeeserver.model.employee.JobRole;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeResponse {

    private String firstName;

    private String lastName;

    private String email;

    private JobRole jobRole;

    private Date dateOfStart;

    private List<KPIFact> kpiFacts;

}
