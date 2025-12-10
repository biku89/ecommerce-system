package com.example.cart_service.model;

import java.math.BigDecimal;

public record OptionDTO (Long id,
                         String name,
                         BigDecimal extraPrice){
}
