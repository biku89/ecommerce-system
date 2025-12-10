package com.example.product_service.service;

import com.example.product_service.exception.NotFoundException;
import com.example.product_service.mapper.ProductConfigurationMapper;
import com.example.product_service.model.Category;
import com.example.product_service.model.CategoryDTO;
import com.example.product_service.model.Product;
import com.example.product_service.repository.CategoryRepository;
import com.example.product_service.repository.ProductRepository;
import com.example.product_service.validate.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final ProductRepository productRepository;
    private final ProductConfigurationMapper productConfigurationMapper;
    private final CategoryRepository categoryRepository;


    public CategoryDTO createCategory(Long productId, String categoryName) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new NotFoundException("Not found product id: " + productId));

        ProductValidator.categoryNameCannotBeNull(categoryName);

        Category category = new Category();
        category.setName(categoryName);
        category.setProduct(product);

        return productConfigurationMapper.toDTO(categoryRepository.save(category));
    }

    public CategoryDTO getCategory(Long categoryId){
        return categoryRepository.findById(categoryId)
                .map(productConfigurationMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Not found category id" + categoryId));
    }

    public CategoryDTO updateCategory(Long categoryId, CategoryDTO configurationOptionDTO){
        Category updatedCategory = productConfigurationMapper.toEntity(configurationOptionDTO);
        Category existingCategory = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Not found category id" + categoryId));

        existingCategory.setName(updatedCategory.getName());

        return productConfigurationMapper.toDTO(categoryRepository.save(existingCategory));
    }

    public void deleteCategory(Long categoryId){
        if (!categoryRepository.existsById(categoryId)){
            throw new NotFoundException("Category not found");
        }
        categoryRepository.deleteById(categoryId);
    }
}