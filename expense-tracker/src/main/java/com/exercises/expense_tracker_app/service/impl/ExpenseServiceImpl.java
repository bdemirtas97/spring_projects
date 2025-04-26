package com.exercises.expense_tracker_app.service.impl;

import com.exercises.expense_tracker_app.ExpenseTrackerAppApplication;
import com.exercises.expense_tracker_app.dto.ExpenseDto;
import com.exercises.expense_tracker_app.entity.Category;
import com.exercises.expense_tracker_app.entity.Expense;
import com.exercises.expense_tracker_app.exceptions.ResourceNotFoundException;
import com.exercises.expense_tracker_app.mapper.ExpenseMapper;
import com.exercises.expense_tracker_app.repository.CategoryRepository;
import com.exercises.expense_tracker_app.repository.ExpenseRepository;
import com.exercises.expense_tracker_app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;
    private final ExpenseTrackerAppApplication expenseTrackerAppApplication;

    @Override
    public ExpenseDto createExpense(ExpenseDto expenseDto) {
        Expense savedExpense = expenseRepository.save(ExpenseMapper.mapToExpense(expenseDto));
        return ExpenseMapper.mapToExpenseDto(savedExpense);
    }

    @Override
    public ExpenseDto getExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("Expense not found with id: " + expenseId));
        return ExpenseMapper.mapToExpenseDto(expense);
    }

    @Override
    public List<ExpenseDto> getAllExpenses() {
        List<Expense> expenses = expenseRepository.findAll();
        return expenses.stream().map(ExpenseMapper::mapToExpenseDto).collect(Collectors.toList());
    }

    @Override
    public ExpenseDto updateExpense(Long expenseId, ExpenseDto expenseDto) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
        expense.setAmount(expenseDto.amount());
        expense.setExpenseDate(expenseDto.expenseDate());
        if(expenseDto.categoryDto() != null){
            Category category = categoryRepository.findById(expenseDto.categoryDto().id()).orElseThrow(() -> new ResourceNotFoundException("Category not found"));
            expense.setCategory(category);
        }
        Expense updatedExpense = expenseRepository.save(expense);
        return ExpenseMapper.mapToExpenseDto(updatedExpense);
    }

    @Override
    public void deleteExpense(Long expenseId) {
        Expense expense = expenseRepository.findById(expenseId).orElseThrow(() -> new ResourceNotFoundException("Expense not found"));
        expenseRepository.delete(expense);
    }
}
