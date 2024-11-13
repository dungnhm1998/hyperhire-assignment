package com.demo.assignment.hyperhire.service;

import com.demo.assignment.hyperhire.model.dto.CategoryDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CategoryService {

    public List<CategoryDto> getCategories();
}
