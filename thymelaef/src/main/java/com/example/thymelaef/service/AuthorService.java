package com.example.thymelaef.service;

import java.util.List;

import com.example.thymelaef.model.Author;

public interface AuthorService {
    
    // Get all data from the database
    List<Author> findAll();

    // Get the data from the table using the id field.
    Author findById(long id);

    // Register
    Author save(Author author);

    // Delete
    void delete(long id);
}
