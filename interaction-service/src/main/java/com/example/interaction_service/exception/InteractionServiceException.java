package com.example.interaction_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InteractionServiceException extends RuntimeException {
    private final HttpStatus httpStatus;
    public InteractionServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
