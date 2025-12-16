package com.example.product_service.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductDTO(Long id,
                         String name,
                         BigDecimal basePrice,
                         ProductType type,
                         Integer stockQuantity) {
}
