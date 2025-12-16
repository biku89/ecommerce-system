package com.example.product_service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
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
    public String getValue(){
        return value;
    }

    @JsonCreator
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
