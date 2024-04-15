package com.springboot.expensetrackerapp.service;

import com.springboot.expensetrackerapp.dto.CategoryDto;
import com.springboot.expensetrackerapp.dto.ExpenseDto;
import com.springboot.expensetrackerapp.entity.Expense;

import java.util.List;

public interface ExpenseService {

    ExpenseDto createExpense(ExpenseDto expenseDto);

    ExpenseDto getExpenseById(Long expenseId);

    List<ExpenseDto> getAllExpenses();

    ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto);

    void deleteExpenseById(Long expenseId);
}
