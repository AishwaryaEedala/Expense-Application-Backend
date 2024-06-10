package com.example.mockproject.ExpenseApplication.service;

import com.example.mockproject.ExpenseApplication.Dto.CategoryDto;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(Long categoryId);
    List<CategoryDto> getAllCategories();
    CategoryDto updateCategory(Long categoryId,CategoryDto updatedCategory);
    void deleteCategory(Long categoryId);
}
