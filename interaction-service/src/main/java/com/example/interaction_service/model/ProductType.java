package com.example.interaction_service.model;

import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum ProductType {
    COMPUTER("computer"),
    SMARTPHONE("smartphone"),
    ELECTRONICS("electronics");

    private final String value;

    ProductType(String value) {
        this.value = value;
    }

    @JsonValue
    private String getValue() {
        return value;
    }

    public static ProductType from(String value) {
        if (value == null) {
            return null;
        }
        return Stream.of(ProductType.values())
                .filter(type -> type.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Incorrect name: " + value));
    }
}
