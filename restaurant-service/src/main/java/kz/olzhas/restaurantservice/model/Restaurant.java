package kz.olzhas.restaurantservice.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_restaurant")
@Builder
public class Restaurant {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "revenue")
    private BigDecimal revenue;

    @Column(name = "profit")
    private BigDecimal profit;

    @Column(name = "owner_id")
    private Long ownerId;

    @Column(name = "expenses")
    private BigDecimal expenses;

}
