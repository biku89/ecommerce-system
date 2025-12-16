package com.example.order_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private String productName;
    private BigDecimal basePrice;
    private BigDecimal extraPrice;
    private Integer quantity;
    private BigDecimal totalPrice;

    @ElementCollection
    private List<String> selectedOptions;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;

}
