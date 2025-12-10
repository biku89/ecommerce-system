package com.example.cart_service.model;

import java.math.BigDecimal;

public record ProductDTO(Long id,
                         String name,
                         BigDecimal basePrice,
                         ProductType type) {
}
