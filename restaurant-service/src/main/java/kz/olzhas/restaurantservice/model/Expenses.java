package kz.olzhas.restaurantservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "electricity")
    private BigDecimal electricity;

    @Column(name = "rent")
    private BigDecimal rent;

    @Column(name = "revenue")
    private BigDecimal revenue;

    @Column(name = "profit")
    private BigDecimal profit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "salary_id")
    private Salary salary;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "custom_id")
    private CustomExpenses customExpenses;

    @Column(name = "date")
    private Date theDate;
}