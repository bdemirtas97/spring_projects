package com.exercises.expense_tracker_app.controller;

import com.exercises.expense_tracker_app.dto.ExpenseDto;
import com.exercises.expense_tracker_app.service.ExpenseService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/expenses")
@AllArgsConstructor
public class ExpenseController {
    private final ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<ExpenseDto> createExpense(@RequestBody ExpenseDto expenseDto){
        ExpenseDto savedExpense = expenseService.createExpense(expenseDto);
        return new ResponseEntity<>(savedExpense, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ExpenseDto> getExpense(@PathVariable("id") Long expenseId){
        ExpenseDto expense = expenseService.getExpense(expenseId);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ExpenseDto>> getAllExpenses(){
        List<ExpenseDto> expenses = expenseService.getAllExpenses();
        return new ResponseEntity<>(expenses, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ExpenseDto> updateExpense(@PathVariable("id") Long expenseId, @RequestBody ExpenseDto expenseDto){
        ExpenseDto expense = expenseService.updateExpense(expenseId, expenseDto);
        return new ResponseEntity<>(expense, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable("id") Long expenseId){
        expenseService.deleteExpense(expenseId);
        return new ResponseEntity<>("Expense deleted", HttpStatus.OK);
    }

}
