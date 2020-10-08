package com.example.thymelaef.repository;

import com.example.thymelaef.model.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long>{
    
}
