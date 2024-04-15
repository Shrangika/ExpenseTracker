package com.springboot.expensetrackerapp.controller;

import com.springboot.expensetrackerapp.dto.CategoryDto;
import com.springboot.expensetrackerapp.dto.ExpenseDto;
import com.springboot.expensetrackerapp.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto)
    {
        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping("{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId)
    {
        ExpenseDto expenseDto= expenseService.getExpenseById(expenseId);
        return ResponseEntity.ok(expenseDto);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses()
    {

        List<ExpenseDto> expenseDtos = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenseDtos);
    }
    @PutMapping("{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId,
                                                      @RequestBody ExpenseDto expenseDto)
    {
        ExpenseDto expense = expenseService.updateExpense(expenseId, expenseDto);
        return ResponseEntity.ok(expense);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId)
    {
        expenseService.deleteExpenseById(expenseId);
        return ResponseEntity.ok("Expense deleted successfully");
    }
}
