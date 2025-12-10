package com.example.order_service.mapper;

import com.example.order_service.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface OrderMapper {
    OrderDTO toDTO(Order order);
    OrderItemDTO toDTO(OrderItem orderItem);
    OrderDetails toOrderDetails(PlaceOrderRequest orderRequest);
    OrderDetailsDTO toOrderDetailsDTO(OrderDetails details);
}
