package com.example.interaction_service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum PaymentMethod {
    BANK_TRANSFER("bank_transfer"),
    BLIK("blik");

    private final String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }

    @JsonCreator
    public static PaymentMethod from(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(PaymentMethod.values())
                .filter(paymentMethod -> paymentMethod.getValue().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Incorrect value: " + value));
    }
}
