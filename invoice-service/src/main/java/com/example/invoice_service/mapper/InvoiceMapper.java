package com.example.invoice_service.mapper;

import com.example.invoice_service.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InvoiceMapper {
    @Mapping(source = "id", target = "orderId")

    @Mapping(source = "orderDetails.firstName", target = "firstName")
    @Mapping(source = "orderDetails.lastName", target = "lastName")
    @Mapping(source = "orderDetails.street", target = "street")
    @Mapping(source = "orderDetails.city", target = "city")
    @Mapping(source = "orderDetails.email", target = "email")
    @Mapping(source = "orderDetails.paymentMethod", target = "paymentMethod")
    @Mapping(source = "orderDetails.deliveryMethod", target = "deliveryMethod")
    Invoice toInvoice(OrderDTO orderDTO);

    InvoiceItem toInvoiceItem(OrderItemDTO orderItemDTO);

    InvoiceDTO toDTO(Invoice invoice);
}
