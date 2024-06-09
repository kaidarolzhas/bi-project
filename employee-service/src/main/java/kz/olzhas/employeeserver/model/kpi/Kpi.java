package kz.olzhas.employeeserver.model.kpi;


import jakarta.persistence.*;
import kz.olzhas.employeeserver.dto.kpi.KpiUserDto;
import kz.olzhas.employeeserver.model.employee.Employee;
import lombok.*;

import static kz.olzhas.employeeserver.util.EntityHelper.ALL_EMPLOYEE_RES_ID;
import static kz.olzhas.employeeserver.util.EntityHelper.ALL_EMPLOYEE_RES_ID_ROLE_ID;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_kpi")
@Builder
@SqlResultSetMapping(
        name = "KpiUserDtoMapping",
        classes = {
                @ConstructorResult(
                        targetClass =  KpiUserDto.class,
                        columns = {
                                @ColumnResult(name = "emlId", type = Long.class),
                                @ColumnResult(name = "kpi", type = Double.class),
                                @ColumnResult(name = "month", type = String.class),
                                @ColumnResult(name = "year", type = String.class),
                                @ColumnResult(name = "username", type = String.class)

                        })})
@SqlResultSetMapping(
        name = "KpiUserDtoRoleMapping",
        classes = {
                @ConstructorResult(
                        targetClass =  KpiUserDto.class,
                        columns = {
                                @ColumnResult(name = "emlId", type = Long.class),
                                @ColumnResult(name = "kpi", type = Double.class),
                                @ColumnResult(name = "month", type = String.class),
                                @ColumnResult(name = "year", type = String.class),
                                @ColumnResult(name = "username", type = String.class)
                        })})
@NamedNativeQueries({
        @NamedNativeQuery(name = "Kpi.getKpiDataByRestaurantId",
                query = ALL_EMPLOYEE_RES_ID,
                resultSetMapping = "KpiUserDtoMapping"),
        @NamedNativeQuery(name = "Kpi.getKpiDataByRestaurantIdRoleId",
                query = ALL_EMPLOYEE_RES_ID_ROLE_ID,
                resultSetMapping = "KpiUserDtoRoleMapping")
})


public class Kpi {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Column(name = "kpi")
    private Double kpi;

    @Column(name = "year")
    private String year;

    @Column(name = "month")
    private String month;
}
