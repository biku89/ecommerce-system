package com.example.order_service.controller;

import com.example.order_service.model.OrderDTO;
import com.example.order_service.model.PlaceOrderRequest;
import com.example.order_service.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/{userId}")
    public OrderDTO placeOrder(
            @PathVariable Long userId,
            @RequestBody PlaceOrderRequest orderRequest){
        return orderService.placeOrder(userId, orderRequest);
    }

    @GetMapping("/{userId}")
    public List<OrderDTO> getOrderByUser(@PathVariable Long userId){
        return orderService.getOrderByUser(userId);
    }
}
