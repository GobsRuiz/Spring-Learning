package com.example.thymelaef.repository;

import com.example.thymelaef.model.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long>{
    
}
