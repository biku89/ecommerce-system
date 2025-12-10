package com.example.product_service.mapper;

import com.example.product_service.model.Product;
import com.example.product_service.model.ProductDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO toDTO(Product product);
    @Mapping(target = "availableConfigurations", ignore = true)
    Product toEntity(ProductDTO productDTO);

}
