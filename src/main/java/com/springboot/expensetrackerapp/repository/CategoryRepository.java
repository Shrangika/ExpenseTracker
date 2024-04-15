package com.springboot.expensetrackerapp.repository;

import com.springboot.expensetrackerapp.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
