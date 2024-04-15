package com.springboot.expensetrackerapp.controller;

import com.springboot.expensetrackerapp.dto.CategoryDto;
import com.springboot.expensetrackerapp.entity.Category;
import com.springboot.expensetrackerapp.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/categories")
public class CategoryController {
    private CategoryService categoryService;

    @PostMapping
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto){
        CategoryDto category = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(category, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId)
    {
        CategoryDto category= categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(category);
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> getAllCategories()
    {

        List<CategoryDto> category = categoryService.getAllCategories();
        return ResponseEntity.ok(category);
    }

    @PutMapping("{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,
                                                      @RequestBody CategoryDto categoryDto)
    {

        CategoryDto category = categoryService.updateCategory(categoryId, categoryDto);
        return ResponseEntity.ok(category);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId)
    {
        categoryService.deleteCategory(categoryId);
        return ResponseEntity.ok("Category deleted successfully");
    }

}
