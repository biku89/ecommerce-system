package com.example.order_service.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum DeliveryMethod {
    COURIER("courier"),
    INPOST("inpost"),
    OWN_PICKUP("own_pickup");

    private final String value;

    DeliveryMethod(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue(){
        return value;
    }

    @JsonCreator
    public static DeliveryMethod from(String value){
        if (value == null){
            return null;
        }
        return Stream.of(DeliveryMethod.values())
                .filter(deliveryMethod -> deliveryMethod.name().equalsIgnoreCase(value))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Incorrect value: " + value));
    }
}
