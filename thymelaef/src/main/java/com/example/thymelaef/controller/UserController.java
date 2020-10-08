package com.example.thymelaef.controller;

import java.net.http.HttpClient.Redirect;
import java.util.List;

import javax.validation.Valid;

import com.example.thymelaef.model.User;
import com.example.thymelaef.repository.UserRepository;
import com.example.thymelaef.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class UserController {

    // Repository
    @Autowired
    private UserService servico;
    
    // Index
    @GetMapping("/usuarios")
    public String index()
    {
        return "user/index";
    }



    // Store or register
    @GetMapping("/usuarios/cadastrar")
    public String form()
    {
        return "user/store";
    }

    @PostMapping("/usuarios/cadastrar")
    public String store(@Valid User user, BindingResult result, RedirectAttributes attributes)
    {
        if(result.hasErrors()){
            attributes.addFlashAttribute("error", "Verifique se os campos obrigatórios foram preenchidos!");
            return "redirect:/usuarios/cadastrar";
        }
        servico.save(user);

        return "redirect:/usuarios/lista";
    }



    // List
    @GetMapping("/usuarios/lista")
    public ModelAndView list()
    {
        ModelAndView mv = new ModelAndView("user/list");
        List<User> users = servico.findAll();
        mv.addObject("users", users);
        return mv;
    }



    // Show
    @GetMapping("/usuarios/{id}")
    public ModelAndView show(@PathVariable("id") long id)
    {
        ModelAndView mv = new ModelAndView("user/show");
        User user = servico.findById(id);
        mv.addObject("user", user);
        return mv;
    }
}
