package com.example.order_service.exception;

import org.springframework.http.HttpStatus;

public class EmptyException extends OrderServiceException {
    public EmptyException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
