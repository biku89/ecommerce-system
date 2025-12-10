package com.example.interaction_service.service;

import com.example.interaction_service.client.CartClient;
import com.example.interaction_service.client.InvoiceClient;
import com.example.interaction_service.client.OrderClient;
import com.example.interaction_service.client.ProductClient;
import com.example.interaction_service.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InteractionService {
    private final ProductClient productClient;
    private final CartClient cartClient;
    private final OrderClient orderClient;
    private final InvoiceClient invoiceClient;

    public PageDTO<ProductDTO> getAllProducts(Pageable pageable){
        return productClient.getAllProducts(pageable);
    }

    public ProductConfigurationDTO getConfiguration(Long id){
        return productClient.getConfiguration(id);
    }

    public List<ProductDTO> getProductsByType(ProductType type){
        return productClient.getProductsByType(type);
    }

    public CartDTO createCart(Long userId){
        return cartClient.createCart(userId);
    }

    public CartDTO getCart(Long userId){
        return cartClient.getCart(userId);
    }

    public CartDTO addItem(Long userId, AddCartItemDTO addCartItemDTO){
        return cartClient.addItem(userId, addCartItemDTO);
    }

    public void removeItemFromCart(Long userId, Long cartItemId){
        cartClient.removeItemFromCart(userId, cartItemId);
    }

    public List<OrderDTO> getOrderByUser(Long userId){
        return orderClient.getOrderByUser(userId);
    }

    public OrderDTO placeOrder(Long userId, PlaceOrderRequest orderRequest){
        return orderClient.placeOrder(userId, orderRequest);
    }

    public InvoiceDTO getInvoiceById(Long invoiceId){
        return invoiceClient.getInvoiceById(invoiceId);
    }
}
