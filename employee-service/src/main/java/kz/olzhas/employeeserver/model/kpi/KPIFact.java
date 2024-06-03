package kz.olzhas.employeeserver.model.kpi;


import com.thoughtworks.xstream.converters.time.YearMonthConverter;
import jakarta.persistence.*;
import kz.olzhas.employeeserver.model.employee.Employee;
import lombok.*;

import java.time.YearMonth;

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

    @Column(name = "year")
    private String year;

    @Column(name = "month")
    private String month;

}
