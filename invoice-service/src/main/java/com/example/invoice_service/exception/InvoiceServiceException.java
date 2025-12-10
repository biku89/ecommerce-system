package com.example.invoice_service.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class InvoiceServiceException extends RuntimeException {
    private final HttpStatus httpStatus;
    public InvoiceServiceException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
