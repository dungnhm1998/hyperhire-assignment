package com.demo.assignment.hyperhire.controller;

import com.demo.assignment.hyperhire.model.dto.CategoryDto;
import com.demo.assignment.hyperhire.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping

    @Operation(description = "get all categories available")
    public List<CategoryDto> getAllCategories() {
        return categoryService.getCategories();
    }

}
