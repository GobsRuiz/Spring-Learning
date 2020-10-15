package com.example.thymelaef.controller;

import javax.servlet.http.HttpServletRequest;

import com.example.thymelaef.model.Author;
import com.example.thymelaef.model.News;
import com.example.thymelaef.repository.NewsRepository;
import com.example.thymelaef.service.AuthorService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class NewsController {

    // Repositorys
    @Autowired
    private NewsRepository newsRep;

    @Autowired
    private AuthorService authorservice;
    
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
    public String store(HttpServletRequest request, @RequestParam("image") MultipartFile imageFile)
    {   
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        int id = Integer.parseInt(request.getParameter("author_id"));
        
        News news = new News();
        news.setTitle(title);
        news.setDescription(description);
        news.setAuthor(authorservice.findById(id));
        newsRep.save(news);

        return "redirect:/noticias";
    }
}
