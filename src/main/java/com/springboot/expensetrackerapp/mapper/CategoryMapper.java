package com.springboot.expensetrackerapp.mapper;

import com.springboot.expensetrackerapp.dto.CategoryDto;
import com.springboot.expensetrackerapp.entity.Category;

public class CategoryMapper {
    public static Category mapToCategory(CategoryDto categoryDto)
    {
        return new Category(
                categoryDto.id(), categoryDto.name()
        );
    }

    public static CategoryDto mapToCategoryDto(Category category)
    {
        return new CategoryDto(
                category.getId(), category.getName()
        );
    }
}
