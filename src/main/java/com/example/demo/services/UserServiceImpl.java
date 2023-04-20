package com.example.demo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.doa.UserRepository;
import com.example.demo.entities.User;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository repo;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Override
    public Integer saveUser(User user) {

        
        user.setPassword(passwordEncoder.encode(user.getPassword())); // Encode the password
        return repo.save(user).getId();

    }

    @Override
    public Optional<User> findByUsername(String username) {

        return repo.findByUsername(username);
    }
    
}
