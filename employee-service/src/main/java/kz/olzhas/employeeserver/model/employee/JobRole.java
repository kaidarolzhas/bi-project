package kz.olzhas.employeeserver.model.employee;


import jakarta.persistence.*;
import kz.olzhas.employeeserver.model.kpi.KpiStandard;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_job_roles")
@Builder
public class JobRole {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "role")
    private String role;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @Column(name = "oklad")
    private Double oklad;

    @Column(name = "bonus")
    private Double bonus;

}
