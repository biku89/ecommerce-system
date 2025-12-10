package com.example.product_service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends ProductServiceException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
