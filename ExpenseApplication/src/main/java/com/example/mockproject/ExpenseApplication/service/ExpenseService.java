package com.example.mockproject.ExpenseApplication.service;

import com.example.mockproject.ExpenseApplication.Dto.ExpenseDto;

import java.util.List;

public interface ExpenseService {
    ExpenseDto createExpense(ExpenseDto expenseDto);
    ExpenseDto getExpenseById(Long expenseId);
    List<ExpenseDto> getAllExpenses();
    ExpenseDto updateExpense(Long expenseId,ExpenseDto updatedExpense);
    void deleteExpense(Long expenseId);

}
