package com.example.thymelaef.repository;

import com.example.thymelaef.model.News;

import org.springframework.data.jpa.repository.JpaRepository;

public interface NewsRepository extends JpaRepository<News, Long>{
    
}
