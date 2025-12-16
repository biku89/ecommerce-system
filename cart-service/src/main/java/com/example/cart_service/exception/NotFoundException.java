package com.example.cart_service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends CartServiceException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
