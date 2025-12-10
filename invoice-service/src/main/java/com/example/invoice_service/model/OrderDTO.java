package com.example.invoice_service.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record OrderDTO(
        Long id,
        Long userId,
        BigDecimal totalPrice,
        LocalDateTime createdAt,
        OrderDetailsDTO orderDetails,
        List<OrderItemDTO> items
) {
}
