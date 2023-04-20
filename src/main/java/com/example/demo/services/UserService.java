package com.example.demo.services;

import java.util.Optional;

import com.example.demo.entities.User;

public interface UserService {

    Integer saveUser(User user);
    Optional<User> findByUsername(String username);

}
