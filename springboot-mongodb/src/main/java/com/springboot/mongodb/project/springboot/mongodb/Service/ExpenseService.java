package com.springboot.mongodb.project.springboot.mongodb.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.mongodb.project.springboot.mongodb.Model.Expense;
import com.springboot.mongodb.project.springboot.mongodb.Repository.ExpenseRepository;

@Service
public class ExpenseService 
{
    
    private final ExpenseRepository expenseRepository;
    
    public ExpenseService(ExpenseRepository expenseRepository) 
    {
        this.expenseRepository = expenseRepository;
    }


    @SuppressWarnings("null")
    public void addExpense(Expense expense)
    {
       expenseRepository.insert(expense);
    }

    @SuppressWarnings("null")
    public void updateExpense(Expense expense)
    {
        Expense savedExpense = expenseRepository.findById(expense.getId()).orElseThrow(()-> new RuntimeException((String.format("Cannot find Expense ID %s", expense.getId()))));
        savedExpense.setExpenseName(expense.getExpenseName());
        savedExpense.setExpenseCategory(expense.getExpenseCategory());
        savedExpense.setExpenseAmount(expense.getExpenseAmount());

        expenseRepository.save(expense);
    }

    public List<Expense> getAllExpenses() 
    {
        return expenseRepository.findAll();
    }

    public Expense getExpenseByName(String name) 
    {
        return expenseRepository.findByName(name).orElseThrow(()->new RuntimeException(String.format("Cannot find expense by name %s",name)));
    }

    @SuppressWarnings("null")
    public void deleteExpense(String id)
    {
        expenseRepository.deleteById(id);

    }
}
