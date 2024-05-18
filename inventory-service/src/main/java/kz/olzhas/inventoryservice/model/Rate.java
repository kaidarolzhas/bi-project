package kz.olzhas.inventoryservice.model;

import jakarta.persistence.*;
import kz.olzhas.inventoryservice.model.Supplier;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "t_rate")
@Builder
public class Rate {
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

    @Column(name = "days_late")
    private int daysLate;

    @Column(name = "rate")
    private double rate;

    @ManyToOne()
    @JoinColumn(name = "supplier_id")
    private Order order;
}
