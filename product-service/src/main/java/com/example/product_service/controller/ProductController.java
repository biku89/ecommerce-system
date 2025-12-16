package com.example.product_service.controller;

import com.example.product_service.model.*;
import com.example.product_service.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public PageDTO<ProductDTO> getAllProducts(Pageable pageable) {
        return productService.getAllProducts(pageable);
    }

    @GetMapping("/type/{type}")
    public List<ProductDTO> getProductsByType(@RequestParam String type){
        ProductType productType = ProductType.from(type);
        return productService.getProductsByType(productType);
    }

    @GetMapping("/{id}")
    public ProductDTO getProductById(@PathVariable Long id){
        return productService.getProductById(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO){
        return productService.createProduct(productDTO);
    }

    @PutMapping("/update/{id}")
    public ProductDTO updateProduct(@PathVariable Long id,
                                    @RequestBody ProductDTO productDTO){
        return productService.updateProduct(id, productDTO);
    }

    @GetMapping("/{id}/configuration")
    public ProductConfigurationDTO getConfiguration(@PathVariable Long id){
        return productService.getConfiguration(id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(Long id){
        productService.deleteProduct(id);
    }

    @PostMapping("/{id}/reduce-stock")
    public void reduceStock(@PathVariable Long id,
                            @RequestParam int quantity){
        productService.reduceStock(id, quantity);
    }
}
