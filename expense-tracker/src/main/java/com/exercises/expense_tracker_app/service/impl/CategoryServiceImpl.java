package com.exercises.expense_tracker_app.service.impl;

import com.exercises.expense_tracker_app.dto.CategoryDto;
import com.exercises.expense_tracker_app.entity.Category;
import com.exercises.expense_tracker_app.exceptions.ResourceNotFoundException;
import com.exercises.expense_tracker_app.mapper.CategoryMapper;
import com.exercises.expense_tracker_app.repository.CategoryRepository;
import com.exercises.expense_tracker_app.service.CategoryService;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;

    CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }
    @Override
    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category savedCategory = categoryRepository.save(CategoryMapper.mapToCategory(categoryDto));
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public CategoryDto getCategoryById(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found for " + categoryId));
        return CategoryMapper.mapToCategoryDto(category);
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categories = categoryRepository.findAll().stream().map(CategoryMapper::mapToCategoryDto).toList();
        return categories;
    }

    @Override
    public CategoryDto updateCategory(Long categoryId, CategoryDto categoryDto) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found for" + categoryId));
        category.setName(categoryDto.name());
        Category savedCategory = categoryRepository.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Override
    public void deleteCategory(Long categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("Category not found for" + categoryId));
        categoryRepository.delete(category);
    }
}
