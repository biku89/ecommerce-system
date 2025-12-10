package com.example.invoice_service.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
public class InvoiceItem {
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
    @Column(name = "selected_option")
    private List<String> selectedOptions;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;
}
