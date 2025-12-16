package com.example.interaction_service.exception;

import org.springframework.http.HttpStatus;

public class ServiceUnavailableException extends InteractionServiceException {
    public ServiceUnavailableException(String message) {
        super(message, HttpStatus.SERVICE_UNAVAILABLE);
    }
}
