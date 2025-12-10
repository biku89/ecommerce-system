package com.example.product_service.model;

import java.math.BigDecimal;

public record OptionRequest(String name, BigDecimal extraPrice) {
}
