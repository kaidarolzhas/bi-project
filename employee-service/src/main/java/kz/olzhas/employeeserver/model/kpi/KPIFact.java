package kz.olzhas.employeeserver.model.kpi;


import jakarta.persistence.*;
import kz.olzhas.employeeserver.model.employee.Employee;
import lombok.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_kpi_fact")
@Builder
public class KPIFact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "name")
    private String name;

    @Column(name = "value")
    private Double value;

    @Column(name = "percent")
    private Double percent;
}
