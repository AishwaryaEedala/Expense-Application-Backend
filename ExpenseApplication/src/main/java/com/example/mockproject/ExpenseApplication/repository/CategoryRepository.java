package com.example.mockproject.ExpenseApplication.repository;

import com.example.mockproject.ExpenseApplication.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;



public interface CategoryRepository extends JpaRepository<Category,Long> {


}
