package com.example.cart_service.exception;

import org.springframework.http.HttpStatus;

public class AlreadyExistsException extends CartServiceException {
    public AlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
