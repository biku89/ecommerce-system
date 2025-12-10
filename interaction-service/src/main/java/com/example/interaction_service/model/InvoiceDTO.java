package com.example.interaction_service.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record InvoiceDTO(
        Long id,
        Long orderId,
        Long userId,
        BigDecimal totalPrice,
        LocalDateTime createdAt,
        String firstName,
        String lastName,
        String email,
        String city,
        String street,
        DeliveryMethod deliveryMethod,
        PaymentMethod paymentMethod,
        List<InvoiceItemDTO> items
) {
}
