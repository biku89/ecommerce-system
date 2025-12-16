package com.example.interaction_service.fallback;

import com.example.interaction_service.client.OrderClient;
import com.example.interaction_service.exception.ServiceUnavailableException;
import com.example.interaction_service.model.OrderDTO;
import com.example.interaction_service.model.OrderDetailsDTO;
import com.example.interaction_service.model.PlaceOrderRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Component
@Slf4j
public class OrderClientFallback implements FallbackFactory<OrderClient> {
    @Override
    public OrderClient create(Throwable cause){
        log.error("Order-service unavailable", cause);

        return new OrderClient() {
            @Override
            public List<OrderDTO> getOrderByUser(Long userId) {
                log.warn("Fallback getOrderByUser for userId={}", userId);
                return List.of();
            }

            @Override
            public OrderDTO placeOrder(Long userId, PlaceOrderRequest orderRequest) {
                throw new ServiceUnavailableException("Order service is currently unavailable");
            }
        };
    }
}
