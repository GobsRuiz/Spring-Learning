package com.example.thymelaef.service.serviceImplement;

import java.util.List;

import com.example.thymelaef.model.Author;
import com.example.thymelaef.repository.AuthorRepository;
import com.example.thymelaef.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorServiceImplement implements AuthorService{
    
    @Autowired
    private AuthorRepository repositorio;

    @Override
    public List<Author> findAll() {
        
        return repositorio.findAll();
    }

    @Override
    public Author findById(long id) {
        
        return repositorio.findById(id).get();
    }

    @Override
    public Author save(Author author) {
        
        return repositorio.save(author);
    }

    @Override
    public void delete(long id) {
		repositorio.deleteById(id);
	}
}
