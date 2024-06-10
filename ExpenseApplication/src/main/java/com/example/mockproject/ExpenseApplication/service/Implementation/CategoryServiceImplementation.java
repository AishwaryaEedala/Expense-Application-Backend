package com.example.mockproject.ExpenseApplication.service.Implementation;

import com.example.mockproject.ExpenseApplication.Dto.CategoryDto;
import com.example.mockproject.ExpenseApplication.Mapper.CategoryMapper;
import com.example.mockproject.ExpenseApplication.exception.ResourceNotFoundException;
import com.example.mockproject.ExpenseApplication.model.Category;
import com.example.mockproject.ExpenseApplication.repository.CategoryRepository;
import com.example.mockproject.ExpenseApplication.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@AllArgsConstructor
@Service
public class CategoryServiceImplementation implements CategoryService {
    private CategoryRepository categoryRepository;

    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category= CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory =  categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategory);

    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId)
                .orElseThrow(()->
                        new ResourceNotFoundException("Category does not exist with given id:"+categoryId));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<Category>categories = categoryRepository.findAll();
        return categories.stream().map((category) -> CategoryMapper.mapToCategoryDto(category))
                .collect(Collectors.toList());
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto updatedCategory) {
        Category category =categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category Does not exist with given id:"+categoryId)
        );
        category.setCategory_name(updatedCategory.getCategory_name());
        Category updatedCategoryObj =categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(updatedCategoryObj) ;
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category =categoryRepository.findById(categoryId).orElseThrow(
                () -> new ResourceNotFoundException("Category Does not exist with given id:"+categoryId)
        );
        categoryRepository.deleteById(categoryId);

    }

}
