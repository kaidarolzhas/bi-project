package kz.olzhas.employeeserver.dto.employee;

import kz.olzhas.employeeserver.model.kpi.KPIFact;
import lombok.*;

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

    private String role;

    private Date dateOfStart;

    private List<KPIFact> kpiFacts;

}
