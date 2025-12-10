package com.example.product_service.mapper;

import com.example.product_service.model.*;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface ProductConfigurationMapper {

    ProductConfigurationDTO toDTO(Product product);

    CategoryDTO toDTO(Category category);

    @Mapping(target = "product", ignore = true)
    Category toEntity(CategoryDTO configurationCategoryDTO);


    OptionDTO toDTO(Option option);

    @Mapping(target = "category", ignore = true)
    Option toEntity(OptionDTO optionDTO);
}
