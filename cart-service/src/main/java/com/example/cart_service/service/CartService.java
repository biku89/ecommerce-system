package com.example.cart_service.service;

import com.example.cart_service.client.ProductServiceClient;
import com.example.cart_service.exception.AlreadyExistsException;
import com.example.cart_service.exception.InsufficientStockException;
import com.example.cart_service.exception.NotFoundException;
import com.example.cart_service.mapper.CartMapper;
import com.example.cart_service.model.*;
import com.example.cart_service.repository.CartRepository;
import com.example.cart_service.validate.CartValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {
    private final ProductServiceClient productServiceClient;
    private final CartRepository cartRepository;
    private final CartMapper cartMapper;

    public CartDTO createCart(Long userId){

        Optional<Cart> existingCart = cartRepository.findByUserId(userId);
        if (existingCart.isPresent()){
            throw new AlreadyExistsException("Cart already exists for user: " + userId);
        }
        Cart cart = new Cart(userId, new ArrayList<>());

        cartRepository.save(cart);
        return cartMapper.toDTO(cart);
    }

    public CartDTO getCart(Long userId) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("Not found cart for user: " + userId));

        List<CartItemDTO> itemDTOS = cart.getItems().stream()
                .map(this::toCartItemDTO)
                .toList();

        BigDecimal summary = itemDTOS.stream()
                .map(CartItemDTO::totalPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return new CartDTO(cart.getId(), userId, itemDTOS, summary);
    }

    public CartDTO addItem(Long userId, AddCartItemDTO addCartItemDTO) {
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("Not found cart for user: " + userId));

        ProductDTO productDTO = productServiceClient.getProductById(addCartItemDTO.productId());
        CartValidator.stockValidate(productDTO, addCartItemDTO);

        CartItem item = new CartItem(addCartItemDTO, cart);

        cart.getItems().add(item);
        cartRepository.save(cart);

        return getCart(userId);
    }

    private CartItemDTO toCartItemDTO(CartItem item) {
        ProductDTO product = productServiceClient.getProductById(item.getProductId());

        BigDecimal basePrice = product.basePrice();

        List<OptionDTO> options = item.getSelectedOptionsIds().stream()
                .map(productServiceClient::getOption)
                .toList();

        BigDecimal extraPrice = options.stream()
                .map(OptionDTO::extraPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        BigDecimal total = basePrice.add(extraPrice).multiply(BigDecimal.valueOf(item.getQuantity()));

        List<String> selectedOptions = options.stream()
                .map(opt -> opt.name() + " (+" + opt.extraPrice() + ")")
                .toList();

        return new CartItemDTO(
                product.id(),
                product.name(),
                basePrice,
                extraPrice,
                item.getQuantity(),
                total,
                selectedOptions
        );
    }

    public void clearCart(Long userId){
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new NotFoundException("Not found cart for user: " + userId));

        cart.getItems().clear();

        cartRepository.save(cart);
    }

    public void removeItemFromCart(Long userId, Long cartItemId){
        Cart cart = cartRepository.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Not found cart for user: " + userId));

        cart.getItems().removeIf(item -> item.getId().equals(cartItemId));
        cartRepository.save(cart);
    }
}
