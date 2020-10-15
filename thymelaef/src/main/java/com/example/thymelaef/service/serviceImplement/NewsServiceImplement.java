package com.example.thymelaef.service.serviceImplement;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import com.example.thymelaef.model.News;
import com.example.thymelaef.repository.NewsRepository;
import com.example.thymelaef.service.NewsService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
    public News save(News news) {
        
        return repositorio.save(news);
    }

    @Override
    public void delete(Long id) {
		repositorio.deleteById(id);
    }
    
    @Override
    public void saveImage(MultipartFile imageFile) throws Exception{
        String folder = "/images/";
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(folder + imageFile.getOriginalFilename());
        Files.write(path, bytes);
    }
}
