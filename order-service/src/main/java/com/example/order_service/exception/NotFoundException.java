package com.example.order_service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends OrderServiceException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
