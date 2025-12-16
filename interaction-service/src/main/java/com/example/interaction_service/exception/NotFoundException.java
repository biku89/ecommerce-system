package com.example.interaction_service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends InteractionServiceException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
