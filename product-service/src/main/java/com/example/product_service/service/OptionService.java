package com.example.product_service.service;

import com.example.product_service.exception.NotFoundException;
import com.example.product_service.mapper.ProductConfigurationMapper;
import com.example.product_service.model.Category;
import com.example.product_service.model.Option;
import com.example.product_service.model.OptionDTO;
import com.example.product_service.repository.CategoryRepository;
import com.example.product_service.repository.OptionRepository;
import com.example.product_service.validate.ProductValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class OptionService {
    private final OptionRepository optionRepository;
    private final CategoryRepository categoryRepository;
    private final ProductConfigurationMapper productConfigurationMapper;

    public OptionDTO addOption(Long categoryId, String name, BigDecimal extraPrice){
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(() -> new NotFoundException("Not found category id: " + categoryId));

        ProductValidator.optionNameCannotBeNull(name);

        Option option = new Option(name,extraPrice,category);

        return productConfigurationMapper.toDTO(optionRepository.save(option));
    }

    public OptionDTO getOption(Long optionId){
        return optionRepository.findById(optionId)
                .map(productConfigurationMapper::toDTO)
                .orElseThrow(() -> new NotFoundException("Not found option id: " + optionId));
    }

    public OptionDTO updateOption(Long optionId, OptionDTO optionDTO){
        Option updateOption = productConfigurationMapper.toEntity(optionDTO);

        Option existingOption = optionRepository.findById(optionId)
                .orElseThrow(() -> new NotFoundException("Not found option id: " + optionId));

        existingOption.setName(updateOption.getName());
        existingOption.setExtraPrice(updateOption.getExtraPrice());

        return productConfigurationMapper.toDTO(optionRepository.save(existingOption));
    }

    public void deleteOption(Long optionId){
        if (!optionRepository.existsById(optionId)){
            throw new NotFoundException("Option not found " + optionId);
        }
        optionRepository.deleteById(optionId);
    }
}
