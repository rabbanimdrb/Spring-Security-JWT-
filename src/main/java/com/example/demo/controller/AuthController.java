package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entities.JwtAuthRequest;
import com.example.demo.entities.JwtAuthResponse;
import com.example.demo.entities.User;
import com.example.demo.security.JwtTokenHelper;
import com.example.demo.services.UserService;

@RestController
public class AuthController {

    @Autowired
    UserService userService;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserDetailsService userDetailsService;

    @Autowired
    JwtTokenHelper jwtTokenHelper;
    
    @PostMapping("/save")
    public String saveUser(@RequestBody User user){
        
        Integer id = userService.saveUser(user);
        String body = "User '"+id+  "'saved";
        return body;
    }

    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> createToken(@RequestBody JwtAuthRequest request){

        //authenticate username and password

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
            request.getUsername(), 
            request.getPassword()
        );

        authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());

        String token = jwtTokenHelper.generateToken(userDetails);

        JwtAuthResponse response = new JwtAuthResponse();

        response.setToken(token);

        return new ResponseEntity<JwtAuthResponse>(response,HttpStatus.OK);

        
        
    }
}
