package com.example.thymelaef.service;

import java.util.List;

import com.example.thymelaef.model.News;

public interface NewsService {
    
    // Get all data from the database
    List<News> findAll();

    // Get the data from the table using the id field.
    News findById(long id);

    // Register
    News save(News news);
}
