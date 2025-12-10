package com.example.order_service.model;

import java.math.BigDecimal;
import java.util.List;

public record OrderItemDTO(
        Long id,
        Long productId,
        String productName,
        BigDecimal basePrice,
        BigDecimal extraPrice,
        Integer quantity,
        BigDecimal totalPrice,
        List<String> selectedOptions
) {
}
