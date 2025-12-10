package com.example.invoice_service.service;

import com.example.invoice_service.exception.NotFoundException;
import com.example.invoice_service.mapper.InvoiceMapper;
import com.example.invoice_service.model.Invoice;
import com.example.invoice_service.model.InvoiceDTO;
import com.example.invoice_service.model.OrderDTO;
import com.example.invoice_service.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class CreatedOrderService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    @KafkaListener(topics = "order-created", groupId = "invoice-group",containerFactory = "kafkaListenerContainerFactory")
    public void listen(OrderDTO orderDTO){
        createInvoice(orderDTO);

    }

    public Invoice createInvoice(OrderDTO order){
        Invoice invoice = invoiceMapper.toInvoice(order);

        invoice.getItems().forEach(invoiceItem -> invoiceItem.setInvoice(invoice));

        Invoice saved = invoiceRepository.save(invoice);
        sendEmail(saved);
        return saved;
    }

    public void sendEmail(Invoice invoice){
        log.info("Invoice: {}, is created", invoice.getId());
    }
    public InvoiceDTO getInvoiceById(Long invoiceId){
        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new NotFoundException("Invoice not found"));
        return invoiceMapper.toDTO(invoice);
    }
}
