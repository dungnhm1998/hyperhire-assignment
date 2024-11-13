package com.demo.assignment.hyperhire.model.dto;

import com.demo.assignment.hyperhire.model.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CategoryDto {

    private String id;
    private String name;
    private String status;
    private int position;
    private Date createAt;

    public static CategoryDto fromCategory(Category entity) {
        return CategoryDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .status(entity.getStatus())
                .position(entity.getPosition())
                .createAt(new Date(entity.getCreateAt().getTime()))
                .build();
    }

    public static List<CategoryDto> fromCategories(List<Category> entities) {

        return entities.stream().map(CategoryDto::fromCategory).collect(Collectors.toList());

    }
}
