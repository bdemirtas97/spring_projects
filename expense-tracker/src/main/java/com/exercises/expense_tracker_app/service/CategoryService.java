package com.exercises.expense_tracker_app.service;

import com.exercises.expense_tracker_app.dto.CategoryDto;
import com.exercises.expense_tracker_app.entity.Category;

import java.util.List;

public interface CategoryService {
    CategoryDto createCategory(CategoryDto categoryDto);
    CategoryDto getCategoryById(Long categoryId);
    List<CategoryDto> getAllCategories();
    CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto);
    void deleteCategory(Long categoryId);
}
