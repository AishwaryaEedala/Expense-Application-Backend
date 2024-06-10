package com.example.mockproject.ExpenseApplication.controller;


import com.example.mockproject.ExpenseApplication.Dto.CategoryDto;
import com.example.mockproject.ExpenseApplication.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @PostMapping("/categories")
    public ResponseEntity<CategoryDto> createCategory(@RequestBody CategoryDto categoryDto) {
        CategoryDto savedCategory = categoryService.createCategory(categoryDto);
        return new ResponseEntity<>(savedCategory, HttpStatus.CREATED);
    }
    @GetMapping("/categories/{id}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable("id") Long categoryId) {
        CategoryDto categoryDto = categoryService.getCategoryById(categoryId);
        return ResponseEntity.ok(categoryDto);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<CategoryDto>> getAllCategories() {
        List<CategoryDto> categories = categoryService.getAllCategories();
        return ResponseEntity.ok(categories);
    }
    @PutMapping("/categories/{id}")
    public ResponseEntity<CategoryDto> updateCategory(@PathVariable("id") Long categoryId,@RequestBody CategoryDto updatedCategory) {
        CategoryDto categoryDto = categoryService.updateCategory(categoryId, updatedCategory);
        return ResponseEntity.ok(categoryDto);
    }
    @DeleteMapping("/categories/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable("id") Long categoryId){
        categoryService.deleteCategory((categoryId));
        return ResponseEntity.ok("Category deleted successfully");
    }
}




