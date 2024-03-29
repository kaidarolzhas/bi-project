package kz.olzhas.employeeserver.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {
    private Long id;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private Date dateOfStart;

    private String role;

    private BigDecimal salary;

}
