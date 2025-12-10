package com.example.cart_service.mapper;

import com.example.cart_service.model.Cart;
import com.example.cart_service.model.CartDTO;
import com.example.cart_service.model.CartItem;
import com.example.cart_service.model.CartItemDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CartMapper {
    Cart toEntity(CartDTO cartDTO);
    CartDTO toDTO(Cart cart);

    @Mapping(target = "productName", ignore = true)
    @Mapping(target = "basePrice", ignore = true)
    @Mapping(target = "extraPrice", ignore = true)
    @Mapping(target = "totalPrice", ignore = true)
    @Mapping(target = "selectedOptions", ignore = true)
    CartItemDTO toDTOCartItem(CartItem item);
}
