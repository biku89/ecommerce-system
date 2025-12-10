package com.example.product_service.controller;

import com.example.product_service.model.OptionDTO;
import com.example.product_service.model.OptionRequest;
import com.example.product_service.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/options")
public class OptionController {
    private final OptionService optionService;

    @PostMapping("/add/{categoryId}")
    public OptionDTO addOption(@PathVariable Long categoryId,
                               @RequestBody OptionRequest request){
        return optionService.addOption(categoryId, request.name(), request.extraPrice());
    }

    @GetMapping("/{optionId}")
    public OptionDTO getOption(@PathVariable Long optionId){
        return optionService.getOption(optionId);
    }

    @PutMapping("/update/{optionId}")
    public OptionDTO updateOption(@PathVariable Long optionId,
                                  @RequestBody OptionDTO optionDTO){
        return optionService.updateOption(optionId, optionDTO);
    }

    @DeleteMapping("/delete/{optionId}")
    void deleteOption(@PathVariable Long optionId){
        optionService.deleteOption(optionId);
    }
}
