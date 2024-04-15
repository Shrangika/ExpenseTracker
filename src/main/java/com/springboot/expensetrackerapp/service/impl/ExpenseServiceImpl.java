package com.springboot.expensetrackerapp.service.impl;

import com.springboot.expensetrackerapp.dto.CategoryDto;
import com.springboot.expensetrackerapp.dto.ExpenseDto;
import com.springboot.expensetrackerapp.entity.Category;
import com.springboot.expensetrackerapp.entity.Expense;
import com.springboot.expensetrackerapp.exceptions.ResourceNotFoundException;
import com.springboot.expensetrackerapp.mapper.ExpenseMapper;
import com.springboot.expensetrackerapp.repository.CategoryRepository;
import com.springboot.expensetrackerapp.repository.ExpenseRepository;
import com.springboot.expensetrackerapp.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class ExpenseServiceImpl implements ExpenseService {

private ExpenseRepository expenseRepository;
private CategoryRepository categoryRepository;
    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense = ExpenseMapper.mapToExpense(expenseDto);
        Expense savedExpense = expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {
       Expense expense = expenseRepository.findById(expenseId)
               .orElseThrow(() -> new ResourceNotFoundException("Expense mot found with id: "+ expenseId));

        return  ExpenseMapper.mapToExpenseDto(expense);

    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream()
                .map((expense) -> ExpenseMapper.mapToExpenseDto(expense))
                .collect(Collectors.toList());

    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
     Expense expense = expenseRepository.findById(expenseId)
             .orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " +expenseId));

     expense.setAmount(expenseDto.amount());
     expense.setExpenseDate(expenseDto.expenseDate());
     if(expenseDto.categoryDto() != null)
     {
         Category category= categoryRepository.findById(expenseDto.categoryDto().id())
                 .orElseThrow(() -> new ResourceNotFoundException(" Category not found with id:" + expenseDto.categoryDto().id()));

         expense.setCategory(category);
     }
     Expense updateExpense = expenseRepository.save(expense);
     return ExpenseMapper.mapToExpenseDto(updateExpense);
    }

    @Override
    public void deleteExpenseById(Long expenseId) {

        Expense expense=expenseRepository.findById(expenseId)
                .orElseThrow(()-> new ResourceNotFoundException("Expense not found with id: " +expenseId));

        expenseRepository.delete(expense);

    }
}
