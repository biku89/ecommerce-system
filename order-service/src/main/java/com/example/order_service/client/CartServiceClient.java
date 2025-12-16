package com.example.order_service.client;

import com.example.order_service.model.CartDTO;
import com.example.order_service.model.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "cartServiceClient", configuration = FeignConfig.class)
public interface CartServiceClient {
    @GetMapping("/cart/{userId}")
    CartDTO getCart(@PathVariable Long userId);

    @DeleteMapping("/cart/clear/{userId}")
    void clearCart(@PathVariable Long userId);
}
