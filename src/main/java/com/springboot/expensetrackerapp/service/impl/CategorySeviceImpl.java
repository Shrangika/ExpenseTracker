package com.springboot.expensetrackerapp.service.impl;

import com.springboot.expensetrackerapp.dto.CategoryDto;
import com.springboot.expensetrackerapp.entity.Category;
import com.springboot.expensetrackerapp.exceptions.ResourceNotFoundException;
import com.springboot.expensetrackerapp.mapper.CategoryMapper;
import com.springboot.expensetrackerapp.repository.CategoryRepository;
import com.springboot.expensetrackerapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class CategorySeviceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category =CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory = categoryRepository.save(category);

        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
       Category category= categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found with id: "+ categoryId));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category> categories = categoryRepository.findAll();
         return categories.stream()
                .map((category) -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found with id: " +categoryId));

        category.setName(categoryDto.name());
        Category updatedCategory =categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(updatedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {

        Category category=categoryRepository.findById(categoryId)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found with id: " +categoryId));

        categoryRepository.delete(category);
    }
}
