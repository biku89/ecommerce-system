package com.example.interaction_service.model;

import java.math.BigDecimal;
import java.util.List;

public record ProductConfigurationDTO(
        Long id,
        String name,
        BigDecimal basePrice,
        ProductType type,
        List<CategoryDTO> availableConfigurations
) {
}
