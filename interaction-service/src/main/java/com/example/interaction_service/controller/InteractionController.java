package com.example.interaction_service.controller;

import com.example.interaction_service.model.*;
import com.example.interaction_service.service.InteractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shop")
public class InteractionController {
    private final InteractionService interactionService;

    @GetMapping("/products")
    public PageDTO<ProductDTO> getAllProducts(Pageable pageable){
        return interactionService.getAllProducts(pageable);
    }

    @GetMapping("/products/{id}/configuration")
    public ProductConfigurationDTO getConfiguration(@PathVariable Long id){
        return interactionService.getConfiguration(id);
    }

    @GetMapping("/products/type/{type}")
    public List<ProductDTO> getProductsByType(@RequestParam String type){
        return interactionService.getProductsByType(type);
    }

    @PostMapping("/cart/{userId}")
    public CartDTO createCart(@PathVariable Long userId){
        return interactionService.createCart(userId);
    }

    @GetMapping("/cart/{userId}")
    public CartDTO getCart(@PathVariable Long userId){
        return interactionService.getCart(userId);
    }

    @PostMapping("/cart/add/{userId}")
    public CartDTO addItem(@PathVariable Long userId,
                           @RequestBody AddCartItemDTO addCartItemDTO){
        return interactionService.addItem(userId, addCartItemDTO);
    }

    @DeleteMapping("/cart/{userId}/{cartItemId}")
    public void removeItemFromCart(@PathVariable Long userId,
                                   @PathVariable Long cartItemId){
        interactionService.removeItemFromCart(userId,cartItemId);
    }

    @GetMapping("/order/{userId}")
    public List<OrderDTO> getOrderByUser(@PathVariable Long userId){
        return interactionService.getOrderByUser(userId);
    }

    @PostMapping("/order/{userId}")
    public OrderDTO placeOrder(@PathVariable Long userId,
                               @RequestBody PlaceOrderRequest orderRequest){
        return interactionService.placeOrder(userId, orderRequest);
    }

    @GetMapping("/invoices/{invoiceId}")
    public InvoiceDTO getInvoiceById(@PathVariable Long invoiceId){
        return interactionService.getInvoiceById(invoiceId);
    }
}
