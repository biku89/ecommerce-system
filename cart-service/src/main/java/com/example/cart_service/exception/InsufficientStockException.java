package com.example.cart_service.exception;

import org.springframework.http.HttpStatus;

public class InsufficientStockException extends CartServiceException {
    public InsufficientStockException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
