package com.springboot.expensetrackerapp.repository;

import com.springboot.expensetrackerapp.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
}
