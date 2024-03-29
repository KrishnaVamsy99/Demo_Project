package com.springboot.mongodb.project.springboot.mongodb.Controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.project.springboot.mongodb.Model.Expense;
import com.springboot.mongodb.project.springboot.mongodb.Service.ExpenseService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping("/api/expense")
public class ExpenseController 
{
    
    private final ExpenseService expenseService;
    private static final Logger logger = LoggerFactory.getLogger(ExpenseController.class);
    
   
    public ExpenseController(ExpenseService expenseService) 
    {
        this.expenseService = expenseService;
    }

    //@SuppressWarnings("rawtypes")
    @PostMapping("/add")
    public ResponseEntity<Expense>addExpense(@RequestBody Expense expense)
    {
        logger.info("Received request to add expense: {}", expense);

        expenseService.addExpense(expense);

        logger.info("Expense added successfully: {}", expense);
        
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Expense> updateExpense(@RequestBody Expense expense)
    {
        expenseService.updateExpense(expense);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses()
    {
        return ResponseEntity.ok(expenseService.getAllExpenses());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Expense> getExpenseByName(@PathVariable String name)
    {
        return ResponseEntity.ok(expenseService.getExpenseByName(name));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Expense> deleteExpense(@PathVariable String id)
    {
        expenseService.deleteExpense(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();   
    }
}
