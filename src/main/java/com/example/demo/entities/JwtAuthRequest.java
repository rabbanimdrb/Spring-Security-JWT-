package com.example.demo.entities;

import lombok.Data;

@Data
public class JwtAuthRequest {
    String username;
    String password;

}
