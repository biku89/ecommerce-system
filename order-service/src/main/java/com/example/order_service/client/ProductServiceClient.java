package com.example.order_service.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "productServiceClient")
public interface ProductServiceClient {
    @PostMapping("/products/{id}/reduce-stock")
    void reduceStock(@PathVariable Long id,
                     @RequestParam int quantity);
}
