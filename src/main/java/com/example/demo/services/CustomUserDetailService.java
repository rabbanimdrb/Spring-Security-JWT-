package com.example.demo.services;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.doa.UserRepository;
import com.example.demo.entities.User;

@Service
public class CustomUserDetailService implements UserDetailsService{


    @Autowired
    UserRepository repo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optUser = repo.findByUsername(username);

        if (optUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username -> "+username);
        }else{
            // Reade from database 
            User user = optUser.get();

            return new org.springframework.security.core.userdetails.User(
                username, 
                user.getPassword(), 
                user.getRoles().stream().map(role -> new SimpleGrantedAuthority(role)).collect(Collectors.toList())
            );
        }

    }
    

}
