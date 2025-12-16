package com.example.product_service.validate;

import com.example.product_service.exception.WrongValueException;
import com.example.product_service.model.CategoryDTO;
import com.example.product_service.model.OptionDTO;
import com.example.product_service.model.ProductDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ProductValidator {

    public static void basePriceCannotLessThenZero(ProductDTO productDTO){
        if (productDTO.basePrice().compareTo(BigDecimal.ZERO) <= 0 ){
            throw new WrongValueException("Base priace must be greater than zero");
        }
    }

    public static void stockLevelCannotLessThenZero(ProductDTO productDTO){
        if (productDTO.stockQuantity() <= 0){
            throw new WrongValueException("Stock quantity must be greater than 0");
        }
    }

    public static void nameCannotBeEmpty(ProductDTO productDTO){
        if (productDTO.name() == null || productDTO.name().trim().isEmpty()){
            throw new WrongValueException("Name cannot be empty");
        }
    }

    public static void categoryNameCannotBeNull(String categoryName){
        if (categoryName == null){
            throw new WrongValueException("Category name cannot be null");
        }
    }

    public static void optionNameCannotBeNull(String name){
        if (name == null){
            throw new WrongValueException("Option name cannot be null");
        }
    }
}
