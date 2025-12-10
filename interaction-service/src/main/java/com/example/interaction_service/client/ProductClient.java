package com.example.interaction_service.client;

import com.example.interaction_service.model.PageDTO;
import com.example.interaction_service.model.ProductConfigurationDTO;
import com.example.interaction_service.model.ProductDTO;
import com.example.interaction_service.model.ProductType;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "productClient")
public interface ProductClient {

    @GetMapping("/products")
    PageDTO<ProductDTO> getAllProducts(Pageable pageable);

    @GetMapping("/products/{id}/configuration")
    ProductConfigurationDTO getConfiguration(@PathVariable Long id);

    @GetMapping("/products/type/{type}")
    List<ProductDTO> getProductsByType(@PathVariable ProductType type);
}
