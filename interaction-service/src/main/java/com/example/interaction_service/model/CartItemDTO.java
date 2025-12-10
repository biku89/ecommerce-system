package com.example.interaction_service.model;

import java.math.BigDecimal;
import java.util.List;

public record CartItemDTO(
        Long productId,
        String productName,
        BigDecimal basePrice,
        BigDecimal extraPrice,
        int quantity,
        BigDecimal totalPrice,
        List<String> selectedOptions
) {
}
