package com.example.interaction_service.client;

import com.example.interaction_service.model.InvoiceDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "invoiceClient")
public interface InvoiceClient {

    @GetMapping("/invoices/{invoiceId}")
    InvoiceDTO getInvoiceById(@PathVariable Long invoiceId);

}
