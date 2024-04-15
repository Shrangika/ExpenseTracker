package com.springboot.expensetrackerapp.mapper;

import com.springboot.expensetrackerapp.dto.CategoryDto;
import com.springboot.expensetrackerapp.dto.ExpenseDto;
import com.springboot.expensetrackerapp.entity.Category;
import com.springboot.expensetrackerapp.entity.Expense;

public class ExpenseMapper {

    public static Expense mapToExpense(ExpenseDto expenseDto)
    {
        Category category = new Category();
        category.setId(expenseDto.categoryDto().id());
        return new Expense(
                expenseDto.id(), expenseDto.amount(),
                expenseDto.expenseDate(),
                category
        );
    }

    public static ExpenseDto mapToExpenseDto(Expense expense)
    {
        return new ExpenseDto(
                expense.getId(), expense.getAmount(),
                expense.getExpenseDate(),
                new CategoryDto(
                        expense.getCategory().getId(),
                        expense.getCategory().getName()
                )
        );
    }
}
