package com.example.thymelaef.controller;

import com.example.thymelaef.model.Author;
import com.example.thymelaef.repository.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AuthorController {

    // Repository
    @Autowired
    private AuthorRepository authorRepository;
    
    // Index
    @GetMapping("/autor")
    public String index()
    {
        return "author/index";
    }



    // Store
    @GetMapping("/autor/cadastrar")
    public String form()
    {
        return "author/store";
    }

    @PostMapping("/autor/cadastrar")
    public String store(Author author)
    {
        authorRepository.save(author);

        return "author/store";
    }
}
