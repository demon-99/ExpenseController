package com.programming.techie.Expense_Tracker.service;

import com.programming.techie.Expense_Tracker.model.Expense;
import com.programming.techie.Expense_Tracker.repository.ExpenseRepository;
import org.springframework.data.mongodb.core.aggregation.ArrayOperators;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    public ExpenseService(ExpenseRepository expenseRepository){
        this.expenseRepository=expenseRepository;
    }
    public void addExpense(Expense expense){
          expenseRepository.insert(expense);
    }
    public void updateExpense(Expense expense){
        Expense savedExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(()->new RuntimeException(
                        String.format("Cannot Find Expense by ID %s",expense.getId())
                ));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());
        expenseRepository.save(expense);
    }
    public List<Expense> getAllExpenses(){
        return expenseRepository.findAll();
    }
    public Expense getExpensesbyName(String name){
        return expenseRepository.findByName(name).orElseThrow(()->new RuntimeException(
                String.format("Cannot Find Expense by Name %s",name)));
    }
    public void deleteExpense(String id){
           expenseRepository.deleteById(id);
    }
    public BigDecimal getTotalExpense(){
        List<Expense> expenses = expenseRepository.findAll();
        BigDecimal sum = BigDecimal.ZERO; // Initialize sum to zero

        for (Expense expense : expenses) {
            BigDecimal amount = expense.getExpenseAmount();
            amount.add(expense.getExpenseAmount());
            sum = sum.add(amount); // Add amount to sum
        }

        return sum;
    }
}
