package com.example.invoice_service.model;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

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
