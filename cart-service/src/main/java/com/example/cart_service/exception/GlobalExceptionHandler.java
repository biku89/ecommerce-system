package com.example.cart_service.exception;

import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.OffsetDateTime;

@Getter
@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CartServiceException.class)
    public ResponseEntity<ErrorMessage> handleCityServiceException(CartServiceException ex) {
        ErrorMessage errorMessage = new ErrorMessage(ex.getMessage(), ex.getHttpStatus(), OffsetDateTime.now());
        return ResponseEntity.status(ex.getHttpStatus()).body(errorMessage);
    }
}
