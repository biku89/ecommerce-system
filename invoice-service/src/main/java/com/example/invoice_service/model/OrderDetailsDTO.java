package com.example.invoice_service.model;

public record OrderDetailsDTO(
        String firstName,
        String lastName,
        String email,
        String city,
        String street,
        DeliveryMethod deliveryMethod,
        PaymentMethod paymentMethod
) {
}
