package com.example.thymelaef.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.thymelaef.model.News;
import com.example.thymelaef.repository.NewsRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NewsController {

    // Repositorys
    @Autowired
    private NewsRepository newsRep;
    
    // Index
    @GetMapping("/noticias")
    public String index()
    {
        return "news/index";
    }



    // Store or register
    @GetMapping("/noticias/publicar")
    public String form()
    {
        return "news/store";
    }

    @PostMapping("/noticias/publicar")
    public String store(HttpServletRequest request)
    {   
        String title = request.getParameter("title");
        News news = new News();
        news.setTitle(title);
        newsRep.save(news);

        return "redirect:/noticias";
    }
}
