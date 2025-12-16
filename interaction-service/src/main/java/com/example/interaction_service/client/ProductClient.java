package com.example.interaction_service.client;

import com.example.interaction_service.fallback.ProductClientFallback;
import com.example.interaction_service.model.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "productClient",configuration = FeignConfig.class, fallbackFactory = ProductClientFallback.class)
public interface ProductClient {

    @GetMapping("/products")
    PageDTO<ProductDTO> getAllProducts(Pageable pageable);

    @GetMapping("/products/{id}/configuration")
    ProductConfigurationDTO getConfiguration(@PathVariable Long id);

    @GetMapping("/products/type/{type}")
    List<ProductDTO> getProductsByType(@RequestParam String type);
}
