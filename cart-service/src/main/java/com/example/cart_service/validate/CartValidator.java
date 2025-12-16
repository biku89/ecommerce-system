package com.example.cart_service.validate;

import com.example.cart_service.exception.AlreadyExistsException;
import com.example.cart_service.exception.InsufficientStockException;
import com.example.cart_service.model.AddCartItemDTO;
import com.example.cart_service.model.ProductDTO;
import com.example.cart_service.repository.CartRepository;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CartValidator {

    public static void stockValidate(ProductDTO productDTO, AddCartItemDTO addCartItemDTO){
        if (productDTO.stockQuantity() == null || productDTO.stockQuantity() < addCartItemDTO.quantity()){
            throw new InsufficientStockException("Insufficient quantity of product. Available quantity: " + productDTO.stockQuantity());
        }
    }
}
