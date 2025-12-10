package com.example.invoice_service.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends InvoiceServiceException {
    public NotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
