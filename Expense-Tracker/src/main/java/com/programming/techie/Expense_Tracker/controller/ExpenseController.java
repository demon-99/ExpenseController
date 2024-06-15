package com.programming.techie.Expense_Tracker.controller;

import com.programming.techie.Expense_Tracker.service.ExpenseService;
import com.programming.techie.Expense_Tracker.model.Expense;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController {
    private final ExpenseService expenseService;
    public ExpenseController(ExpenseService expenseService){
        this.expenseService=expenseService;
    }
    @PostMapping
    public ResponseEntity addExpense(@RequestBody Expense expense){
        expenseService.addExpense(expense);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    @PutMapping
    public ResponseEntity updateExpense(@RequestBody Expense expense){
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }
    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(){
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }
    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpensesbyName(@PathVariable String name){
        return ResponseEntity.ok(expenseService.getExpensesbyName(name));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteExpense(@PathVariable String id){
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @GetMapping("/TotalExpense")
    public ResponseEntity<BigDecimal> getTotalExpense(){
        return ResponseEntity.ok(expenseService.getTotalExpense());
    }
}
