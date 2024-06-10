package com.example.mockproject.ExpenseApplication.Mapper;

import com.example.mockproject.ExpenseApplication.Dto.ExpenseDto;
import com.example.mockproject.ExpenseApplication.model.Expense;

public class ExpenseMapper {
    public static ExpenseDto mapToExpenseDto(Expense expense) {
        return new ExpenseDto(
                expense.getId(),
                expense.getExpensedate(),
                expense.getDescription(),
                expense.getLocation(),
                expense.getRupees(),
                expense.getCategory_name()
        );
    }
    public static Expense  mapToExpense(ExpenseDto expenseDto){
        return new Expense(
                expenseDto.getId(),
                expenseDto.getExpensedate(),
                expenseDto.getDescription(),
                expenseDto.getLocation(),
                expenseDto.getRupees(),
                expenseDto.getCategory_name()

                );
    }
}
