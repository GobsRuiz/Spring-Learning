package com.example.thymelaef.controller;

import java.util.List;

import javax.validation.Valid;

import com.example.thymelaef.model.Author;
import com.example.thymelaef.repository.AuthorRepository;
import com.example.thymelaef.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AuthorController {

    // Repository
    @Autowired
    private AuthorService authorservice;

    @Autowired
    private AuthorRepository authorrepository;
    
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
        authorservice.save(author);

        return "author/store";
    }



    // List
    @GetMapping("/autor/lista")
    public ModelAndView lista()
    {
        ModelAndView mv = new ModelAndView("author/list");
        List<Author> authors = authorservice.findAll();
        mv.addObject("authors", authors);
        return mv;
    }



    // Show
    @GetMapping("/autor/detalhes/{id}")
    public ModelAndView show(@PathVariable("id") long id)
    {
        ModelAndView mv = new ModelAndView("author/show");
        Author author = authorservice.findById(id);
        mv.addObject("author", author);
        return mv;
    }



    // Edit
    @GetMapping("/autor/editar/{id}")
    public String edit(@PathVariable("id") long id, Model model)
    {
        Author author = authorservice.findById(id);

        
        return "author/edit";
    }

    // Update
    @RequestMapping("/autor/update/{id}")
    public String update(@PathVariable("id") long id, @Valid Author author, BindingResult result, Model model)
    {
        if(result.hasErrors()) {
            return "author/edit";
        }

        authorservice.save(author);
        return "redirect:/autor/lista";
    }



    // Delete
    @RequestMapping("/autor/deletar/{id}")
    public String delete(@PathVariable("id") long id)
    {
        authorservice.delete(id);
        return "redirect:/autor/lista";
    }
}
