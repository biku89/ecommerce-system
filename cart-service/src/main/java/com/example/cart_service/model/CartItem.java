package com.example.cart_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CartItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long productId;
    private Integer quantity;

    @ElementCollection
    private List<Long> selectedOptionsIds;

    @ManyToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;
}
