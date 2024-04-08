package kz.olzhas.restaurantservice.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_restaurant")
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "city")
    private String city;

    @Column(name = "revenue")
    private BigDecimal revenue;

    @Column(name = "profit")
    private BigDecimal profit;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "expenses_id")
    private Expenses expenses;


}