package kz.olzhas.restaurantservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_custom_expenses")
@Entity
@Builder
public class CustomExpenses {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "cost")
    private BigDecimal cost;

    @Column(name = "date")
    private Date theDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expenses_id")
    private Expenses expenses;
}
