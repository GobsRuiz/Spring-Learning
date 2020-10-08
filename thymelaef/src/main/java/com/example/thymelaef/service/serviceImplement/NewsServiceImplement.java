package com.example.thymelaef.service.serviceImplement;

import java.util.List;

import com.example.thymelaef.model.News;
import com.example.thymelaef.repository.NewsRepository;
import com.example.thymelaef.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImplement implements NewsService{
 
    @Autowired
    private NewsRepository repositorio;

    @Override
    public List<News> findAll() {
        
        return repositorio.findAll();
    }

    @Override
    public News findById(long id) {
        
        return repositorio.findById(id).get();
    }

    @Override
    public News save(News News) {
        
        return repositorio.save(News);
    }
}
