package com.example.mockproject.ExpenseApplication.Mapper;

import com.example.mockproject.ExpenseApplication.Dto.CategoryDto;
import com.example.mockproject.ExpenseApplication.Dto.ExpenseDto;
import com.example.mockproject.ExpenseApplication.model.Category;
import com.example.mockproject.ExpenseApplication.model.Expense;

public class CategoryMapper {
    public static CategoryDto mapToCategoryDto(Category category) {
        return new CategoryDto(
                category.getId(),
                category.getCategory_name()
        );
    }
    public static Category  mapToCategory(CategoryDto categoryDto){
        return new Category(
                categoryDto.getId(),
                categoryDto.getCategory_name()
        );

    }
}
