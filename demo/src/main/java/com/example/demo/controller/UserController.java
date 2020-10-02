package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    
    @Autowired
    private UserRepository userRepository;

    // Store
    @GetMapping("/cadastrar-usuario")
    public String index()
    {
        return "user/index";
    }

    @PostMapping("/cadastrar-usuario")
    public String store(User user)
    {
        userRepository.save(user);
        return "redirect:/cadastrar-usuario";
    }
}