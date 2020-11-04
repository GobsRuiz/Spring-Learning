package com.fatec.projetoIntegrador4.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TesteController {
    
    // Index
    @GetMapping("/teste")
    public String index()
    {
        return "test/teste";
    }
}
