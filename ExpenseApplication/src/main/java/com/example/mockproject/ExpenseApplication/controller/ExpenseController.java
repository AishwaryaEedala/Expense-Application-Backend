package com.example.mockproject.ExpenseApplication.controller;
import com.example.mockproject.ExpenseApplication.Dto.ExpenseDto;
import com.example.mockproject.ExpenseApplication.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping("/expenses")
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto) {
        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.CREATED);
    }

    @GetMapping("/expenses/{id}")
    public ResponseEntity<ExpenseDto> getExpenseById(@PathVariable("id") Long expenseId) {
        ExpenseDto expenseDto = expenseService.getExpenseById(expenseId);
        return ResponseEntity.ok(expenseDto);
    }

    @GetMapping("/expenses")
    public ResponseEntity<List<ExpenseDto>> getAllExpenses() {
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return ResponseEntity.ok(expenses);
    }
@PutMapping("/expenses/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId,@RequestBody ExpenseDto updatedExpense) {
        ExpenseDto expenseDto = expenseService.updateExpense(expenseId, updatedExpense);
        return ResponseEntity.ok(expenseDto);
    }
    @DeleteMapping("/expenses/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        expenseService.deleteExpense((expenseId));
        return ResponseEntity.ok("Expense deleted successfully");
    }
}


