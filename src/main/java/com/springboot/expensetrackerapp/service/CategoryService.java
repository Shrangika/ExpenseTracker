package com.springboot.expensetrackerapp.service;

import com.springboot.expensetrackerapp.dto.CategoryDto;
import org.springframework.stereotype.Service;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);

    CategoryDto getCategoryById(Long categoryId);

    List<CategoryDto> getAllCategories();

    CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto);

    void deleteCategory(Long categoryId);
}
