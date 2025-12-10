package com.example.product_service.model;

import java.math.BigDecimal;
import java.util.List;

public record ProductDTO(Long id,
                         String name,
                         BigDecimal basePrice,
                         ProductType type) {
}
