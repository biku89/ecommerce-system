package com.example.cart_service.model;

import java.util.List;

public record AddCartItemDTO(
        Long productId,
        Integer quantity,
        List<Long> optionIds) {
}
