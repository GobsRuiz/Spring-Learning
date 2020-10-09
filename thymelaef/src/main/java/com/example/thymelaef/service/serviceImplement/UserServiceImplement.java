package com.example.thymelaef.service.serviceImplement;

import java.util.List;

import com.example.thymelaef.model.User;
import com.example.thymelaef.repository.UserRepository;
import com.example.thymelaef.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository repositorio;

    @Override
    public List<User> findAll() {
        
        return repositorio.findAll();
    }

    @Override
    public User findById(long id) {
        
        return repositorio.findById(id).get();
    }

    @Override
    public User save(User user) {
        
        return repositorio.save(user);
    }
    
    @Override
    public void delete(Long id) {
		repositorio.delete(id);
	}
}
