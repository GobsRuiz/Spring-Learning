package com.example.thymelaef.service;

import java.util.List;

import com.example.thymelaef.model.User;

public interface UserService {
    
    // Get all data from the database
    List<User> findAll();

    // Get the data from the table using the id field.
    User findById(long id);

    // Register
    User save(User user);
}
