package com.example.demo.security;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenHelper {

    String secret = "secretttt";
    // 432A462D4A614E645267556B58703273357538782F413F4428472B4B62506553

    // 8. Validate token
    public Boolean validateToken(String token, UserDetails userDetails){
        final String username = getUsernameFromToken(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    // 7.Token expired or not 
    public Boolean isTokenExpired(String token){
        final Date expiration = getExpirationFromToken(token);
        return expiration.before(new Date());
    }

    // 6. Usernamew
    public String getUsernameFromToken(String token){
        return getClaimsFromToken(token, Claims::getSubject);
    }

    // 5.Expiration Date
    public Date getExpirationFromToken(String token){
        return getClaimsFromToken(token, Claims::getExpiration);
    }

    // 4. Method to help us retrieve individual claims
    public <T> T getClaimsFromToken(String token, Function<Claims, T> claimsResolver){
        
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }


    // 3.Get all the claims
    public Claims getAllClaimsFromToken(String token){
        return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
    }

    // 2. 
    public String generateToken(UserDetails userDetails){

        Map<String, Object> claims = new HashMap<>();
        return doGenerateToken(claims, userDetails.getUsername());
    }

    // 1.GenerateToken
    public String doGenerateToken(Map<String, Object> claims, String subject){

        return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(subject)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 5*60*60*100))
                    .signWith(SignatureAlgorithm.HS256, secret)
                    .compact();
    } 
    
}
