package com.example.product_service.controller;

import com.example.product_service.model.CategoryDTO;
import com.example.product_service.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    @PostMapping("/id/{productId}")
    public CategoryDTO createCategory(@PathVariable Long productId,
                                      @RequestParam String categoryName){
        return categoryService.createCategory(productId,categoryName);
    }

    @GetMapping("/{categoryId}")
    public CategoryDTO getCategory(@PathVariable Long categoryId){
        return categoryService.getCategory(categoryId);
    }

    @PutMapping("/update/{categoryId}")
    public CategoryDTO updateCategory(@PathVariable Long categoryId, CategoryDTO categoryDTO){
        return categoryService.updateCategory(categoryId,categoryDTO);
    }

    @DeleteMapping("/delete/{categoryId}")
    void deleteCategory(@PathVariable Long categoryId){
        categoryService.deleteCategory(categoryId);
    }
}
