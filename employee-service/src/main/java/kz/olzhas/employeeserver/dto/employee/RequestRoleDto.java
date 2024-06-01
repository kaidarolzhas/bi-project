package kz.olzhas.employeeserver.dto.employee;

import jakarta.persistence.Column;
import kz.olzhas.employeeserver.model.employee.JobRole;
import lombok.*;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestRoleDto {
    private Long id;

    private String role;

    private Long restaurantId;

    private Double oklad;

    private Double bonus;
}
