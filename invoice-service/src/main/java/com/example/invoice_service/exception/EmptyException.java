package com.example.invoice_service.exception;

import org.springframework.http.HttpStatus;

public class EmptyException extends InvoiceServiceException {
    public EmptyException(String message) {
        super(message, HttpStatus.CONFLICT);
    }
}
