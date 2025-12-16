package com.example.product_service.exception;

import org.springframework.http.HttpStatus;

public class WrongValueException extends ProductServiceException {
    public WrongValueException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
