package com.example.cart_service.client;

import com.example.cart_service.model.FeignConfig;
import com.example.cart_service.model.OptionDTO;
import com.example.cart_service.model.ProductConfigurationDTO;
import com.example.cart_service.model.ProductDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "productServiceClient", configuration = FeignConfig.class)
public interface ProductServiceClient {

    @GetMapping("/products/{id}")
    ProductDTO getProductById(@PathVariable Long id);

    @GetMapping("/options/{optionId}")
    OptionDTO getOption(@PathVariable Long optionId);
}
