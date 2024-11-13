package com.demo.assignment.hyperhire.service.impl;

import com.demo.assignment.hyperhire.model.dto.CategoryDto;
import com.demo.assignment.hyperhire.model.entity.Category;
import com.demo.assignment.hyperhire.repository.CategoryRepository;
import com.demo.assignment.hyperhire.service.CategoryService;
import com.demo.assignment.hyperhire.util.StatePool;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public List<CategoryDto> getCategories() {
        List<Category> categories = categoryRepository.findAllByStatusOrderByPositionAsc(StatePool.AVAILABLE.getCode());

        return CategoryDto.fromEntities(categories);
    }

}
