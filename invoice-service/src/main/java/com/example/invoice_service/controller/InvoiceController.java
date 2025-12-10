package com.example.invoice_service.controller;

import com.example.invoice_service.model.Invoice;
import com.example.invoice_service.model.InvoiceDTO;
import com.example.invoice_service.service.CreatedOrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/invoices")
@RequiredArgsConstructor
public class InvoiceController {
    private final CreatedOrderService createdOrderService;

    @GetMapping("/{invoiceId}")
    public InvoiceDTO getInvoiceById(
            @PathVariable Long invoiceId
    ){
        return createdOrderService.getInvoiceById(invoiceId);
    }
}
