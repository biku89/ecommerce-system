package com.example.interaction_service.model;

import java.util.List;

public record CategoryDTO(
        Long id,
        String name,
        List<OptionDTO> options
) {
}
