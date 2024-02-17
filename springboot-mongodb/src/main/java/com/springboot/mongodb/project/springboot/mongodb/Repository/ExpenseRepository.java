package com.springboot.mongodb.project.springboot.mongodb.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springboot.mongodb.project.springboot.mongodb.Model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String>
{
    @Query("{'name': ?0}")
    Optional<Expense> findByName(String name);
}
