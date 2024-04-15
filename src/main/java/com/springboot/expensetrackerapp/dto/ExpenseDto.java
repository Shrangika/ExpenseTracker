package com.springboot.expensetrackerapp.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ExpenseDto(Long id,
                         BigDecimal amount,
                         LocalDate expenseDate,
                         CategoryDto categoryDto) {
}
