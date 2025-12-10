package com.example.order_service.service;

import com.example.order_service.client.CartServiceClient;
import com.example.order_service.exception.EmptyException;
import com.example.order_service.mapper.OrderMapper;
import com.example.order_service.model.*;
import com.example.order_service.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final CartServiceClient cartServiceClient;
    private final OrderMapper orderMapper;
    private final KafkaSender kafkaSender;

    public OrderDTO placeOrder(Long userId, PlaceOrderRequest orderRequest){

        CartDTO cartDTO = cartServiceClient.getCart(userId);
        if (cartDTO.items().isEmpty()){
            throw new EmptyException("Cart is empty");
        }

        Order order = new Order();
        order.setUserId(userId);
        order.setCreatedAt(LocalDateTime.now());
        order.setTotalPrice(cartDTO.summaryPrice());

        OrderDetails orderDetails = orderMapper.toOrderDetails(orderRequest);
        order.setOrderDetails(orderDetails);

        for (CartItemDTO c : cartDTO.items()){
            OrderItem orderItem = new OrderItem();

            orderItem.setProductId(c.productId());
            orderItem.setProductName(c.productName());
            orderItem.setBasePrice(c.basePrice());
            orderItem.setExtraPrice(c.extraPrice());
            orderItem.setQuantity(c.quantity());
            orderItem.setTotalPrice(c.totalPrice());
            orderItem.setSelectedOptions(c.selectedOptions());

            orderItem.setOrder(order);
            order.getItems().add(orderItem);
        }

        Order save = orderRepository.save(order);
        kafkaSender.sendOrderCreated(orderMapper.toDTO(order));

        cartServiceClient.clearCart(userId);

        return orderMapper.toDTO(save);
    }

    public List<OrderDTO> getOrderByUser(Long userId){
        return orderRepository.findByUserId(userId)
                .stream()
                .map(orderMapper::toDTO)
                .toList();
    }
}
