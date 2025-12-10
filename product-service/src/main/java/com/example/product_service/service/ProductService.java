package com.example.product_service.service;

import com.example.product_service.exception.NotFoundException;
import com.example.product_service.mapper.ProductConfigurationMapper;
import com.example.product_service.mapper.ProductMapper;
import com.example.product_service.model.*;
import com.example.product_service.repository.CategoryRepository;
import com.example.product_service.repository.OptionRepository;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.validate.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final ProductConfigurationMapper productConfigurationMapper;

    public PageDTO<ProductDTO> getAllProducts(Pageable pageable) {
        return PageDTO.from(productRepository.findAll(pageable), productMapper::toDTO);
    }

    public List<ProductDTO> getProductsByType(ProductType type){
        return productRepository.findByType(type)
                .stream()
                .map(productMapper::toDTO)
                .toList();
    }

    public ProductDTO getProductById(Long id) {
        return productRepository.findById(id).map(productMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Not found product id: " + id));
    }


    public ProductDTO createProduct(ProductDTO productDTO) {
        ProductValidator.basePriceCannotLessThenZero(productDTO);
        ProductValidator.nameCannotBeEmpty(productDTO);

        Product product = productMapper.toEntity(productDTO);
        productRepository.save(product);

        return productMapper.toDTO(product);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Not found product id: " + id));

        existingProduct.updateProduct(productDTO);

        return productMapper.toDTO(productRepository.save(existingProduct));
    }

    public void deleteProduct(Long id) {
        if (!productRepository.existsById(id)){
            throw new NotFoundException("Product id not found: " + id);
        }

        productRepository.deleteById(id);
    }


    public ProductConfigurationDTO getConfiguration(Long productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Not found product id: " + productId));
        return productConfigurationMapper.toDTO(product);
    }
}
