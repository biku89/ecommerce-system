package com.example.interaction_service.model;

public record PlaceOrderRequest(
        String firstName,
        String lastName,
        String email,
        String city,
        String street,
        DeliveryMethod deliveryMethod,
        PaymentMethod paymentMethod
){
}
