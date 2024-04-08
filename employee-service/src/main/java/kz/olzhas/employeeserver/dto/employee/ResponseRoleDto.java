package kz.olzhas.employeeserver.dto.employee;

import kz.olzhas.employeeserver.model.employee.JobRole;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseRoleDto {
    private String role;
}
