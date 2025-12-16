package com.example.product_service.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Option {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private BigDecimal extraPrice;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    public Option(String name, BigDecimal extraPrice, Category category){
        this.name = name;
        this.extraPrice = extraPrice;
        this.category = category;
    }
}
