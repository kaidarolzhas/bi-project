package kz.olzhas.restaurantservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_expenses")
@Builder
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "electricity")
    private BigDecimal electricity;

    @Column(name = "rent")
    private BigDecimal rent;

    @OneToMany(mappedBy = "expenses", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Salary> salaryList;

    @OneToMany(mappedBy = "expenses", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CustomExpenses> customExpenses;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "restaurant_id")
    private Restaurant restaurant;
}
