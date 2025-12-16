package com.example.interaction_service.client;

import com.example.interaction_service.fallback.OrderClientFallback;
import com.example.interaction_service.model.FeignConfig;
import com.example.interaction_service.model.OrderDTO;
import com.example.interaction_service.model.PlaceOrderRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "orderClient", configuration = FeignConfig.class, fallbackFactory = OrderClientFallback.class)
public interface OrderClient {

    @GetMapping("/order/{userId}")
    List<OrderDTO> getOrderByUser(
            @PathVariable Long userId);

    @PostMapping("/order/{userId}")
    OrderDTO placeOrder(@PathVariable Long userId,
                        @RequestBody PlaceOrderRequest orderRequest);
}
