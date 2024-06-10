package com.example.mockproject.ExpenseApplication.repository;

import com.example.mockproject.ExpenseApplication.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

}
