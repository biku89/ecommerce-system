package com.example.interaction_service.client;

import com.example.interaction_service.model.AddCartItemDTO;
import com.example.interaction_service.model.CartDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "cartClient")
public interface CartClient {

    @PostMapping("/cart/{userId}")
    CartDTO createCart(@PathVariable Long userId);

    @GetMapping("/cart/{userId}")
    CartDTO getCart(@PathVariable Long userId);

    @PostMapping("/cart/add/{userId}")
    CartDTO addItem(@PathVariable Long userId,
                    @RequestBody AddCartItemDTO addCartItemDTO);

    @DeleteMapping("/cart/remove/{userId}/{cartItemId}")
    void removeItemFromCart(@PathVariable Long userId,
                            @PathVariable Long cartItemId);
}
