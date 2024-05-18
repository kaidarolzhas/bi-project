package kz.olzhas.inventoryservice.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

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

    @Column(name = "adress")
    private double price;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "total_count")
    private int totalCount;

    @Column(name = "date_delivery")
    private Date deliver;

    @Column(name = "date_of_arrive")
    private Date arrive;
    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;
}
