package com.example.mockproject.ExpenseApplication.service.Implementation;

import com.example.mockproject.ExpenseApplication.Dto.ExpenseDto;
import com.example.mockproject.ExpenseApplication.Mapper.ExpenseMapper;
import com.example.mockproject.ExpenseApplication.exception.ResourceNotFoundException;
import com.example.mockproject.ExpenseApplication.model.Expense;
import com.example.mockproject.ExpenseApplication.repository.ExpenseRepository;
import com.example.mockproject.ExpenseApplication.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseServiceImplementation implements ExpenseService {
    private ExpenseRepository expenseRepository;
    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense expense= ExpenseMapper.mapToExpense(expenseDto);
        Expense savedExpense =  expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpenseById(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Expense does not exist with given id:"+expenseId));
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense>expenses = expenseRepository.findAll();
        return expenses.stream().map((expense) -> ExpenseMapper.mapToExpenseDto(expense))
                .collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto updatedExpense) {
        Expense expense =expenseRepository.findById(expenseId).orElseThrow(
                () -> new ResourceNotFoundException("Expense Does not exist with given id:"+expenseId)
        );
        expense.setRupees(updatedExpense.getRupees());
        expense.setDescription(updatedExpense.getDescription());
        expense.setLocation(updatedExpense.getLocation());
        expense.setExpensedate(updatedExpense.getExpensedate());
        expense.setCategory_name((updatedExpense.getCategory_name()));
        Expense updatedExpenseObj =expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(updatedExpenseObj) ;
    }

    @Override
    public void deleteExpense(Long expenseId) {
        Expense expense =expenseRepository.findById(expenseId).orElseThrow(
                () -> new ResourceNotFoundException("Expense Does not exist with given id:"+expenseId)
        );
        expenseRepository.deleteById(expenseId);
    }
}
