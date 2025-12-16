package com.example.invoice_service.model;

import java.math.BigDecimal;
import java.util.List;

public record InvoiceItemDTO(
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
