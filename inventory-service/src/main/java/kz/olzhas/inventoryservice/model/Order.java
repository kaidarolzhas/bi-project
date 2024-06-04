package kz.olzhas.inventoryservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_order")
@Builder
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "order_name")
    private String name;

    @Column(name = "status")
    private String status;

    @Column(name = "adress")
    private double price;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "total_count")
    private int totalCount;

    @Column(name = "date_of_arrive")
    private LocalDate arrive;


    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Product> productList;

}
