package kz.olzhas.employeeserver.model.employee;

import jakarta.persistence.*;
import kz.olzhas.employeeserver.model.kpi.KPIFact;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_employee")
@Builder
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "restaurant_id")
    private Long restaurantId;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private JobRole jobRole;

    @Column(name = "date_of_start")
    private LocalDate dateOfStart;

    @Column(name = "kpi_month")
    private Double kpiMonth;

    @Column(name = "kpi_weak")
    private Double kpiWeak;

}
