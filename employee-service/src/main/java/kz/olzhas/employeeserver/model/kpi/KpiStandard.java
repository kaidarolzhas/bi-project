package kz.olzhas.employeeserver.model.kpi;


import jakarta.persistence.*;
import kz.olzhas.employeeserver.model.employee.Employee;
import kz.olzhas.employeeserver.model.employee.JobRole;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_kpi_standard")
public class KpiStandard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Double value;

    @Column(name = "percent")
    private Double percent;

    @ManyToOne()
    @JoinColumn(name = "role_id")
    private JobRole jobRole;


}
