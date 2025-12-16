package com.example.cart_service.controller;

import com.example.cart_service.model.*;
import com.example.cart_service.service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/cart")
public class CartController {
    private final CartService cartService;

    @PostMapping("/{userId}")
    public CartDTO createCart(@PathVariable Long userId){
        return cartService.createCart(userId);
    }

    @GetMapping("/{userId}")
    public CartDTO getCart(@PathVariable Long userId) {
        return cartService.getCart(userId);
    }

    @PostMapping("/add/{userId}")
    public CartDTO addItem(
            @PathVariable Long userId,
            @RequestBody AddCartItemDTO addCartItemDTO
    ) {
        return cartService.addItem(userId, addCartItemDTO);
    }

    @DeleteMapping("/clear/{userId}")
    public void clearCart(@PathVariable Long userId){
        cartService.clearCart(userId);
    }

    @DeleteMapping("/remove/{userId}/{cartItemId}")
    public void removeItemFromCart(@PathVariable Long userId,
                                   @PathVariable Long cartItemId){
        cartService.removeItemFromCart(userId ,cartItemId);
    }


}
