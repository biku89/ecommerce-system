package com.example.order_service.model;

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
