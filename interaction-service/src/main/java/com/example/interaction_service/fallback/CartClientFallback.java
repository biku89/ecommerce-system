package com.example.interaction_service.fallback;

import com.example.interaction_service.client.CartClient;
import com.example.interaction_service.exception.ServiceUnavailableException;
import com.example.interaction_service.model.AddCartItemDTO;
import com.example.interaction_service.model.CartDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

@Component
@Slf4j
public class CartClientFallback implements FallbackFactory<CartClient> {
    @Override
    public CartClient create(Throwable cause){
        log.error("Cart-service unavailable", cause);

        return new CartClient() {

            @Override
            public CartDTO createCart(Long userId) {
                throw new ServiceUnavailableException("Cart service unavailable");
            }

            @Override
            public CartDTO getCart(Long userId) {
                return new CartDTO(
                        null,
                        userId,
                        List.of(),
                        BigDecimal.ZERO
                );
            }

            @Override
            public CartDTO addItem(Long userId, AddCartItemDTO addCartItemDTO) {
                throw new ServiceUnavailableException("Cannot add item - cart service unavailable");
            }

            @Override
            public void removeItemFromCart(Long userId, Long cartItemId) {
                throw new ServiceUnavailableException("Cannot remove item - cart service unavailable");

            }
        };
    }
}
