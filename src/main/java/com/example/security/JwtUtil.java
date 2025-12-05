package com.example.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {

    private final String issuer = "gamingdepot";
    private final Key key;
    private final Long expirationMs;


    public JwtUtil(@Value("${jwt.secret}") String base64Secret, @Value("${jwt.expiration-ms}") Long expirationMs) {
        if(base64Secret == null || base64Secret.isBlank()) {
            throw new IllegalArgumentException("JWT secret must be configured in env var JWT_SECRET");
        }

        byte[] keyBytes = Base64.getDecoder().decode(base64Secret);
        this.key = Keys.hmacShaKeyFor(keyBytes);
        this.expirationMs = expirationMs;
    }

    public String generateToken(String username, Long user_id) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuer(issuer)
                .claim("uid", user_id)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .signWith(key)
                .compact();
    }

    public Jws<Claims> validateToken(String token) throws JwtException {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token);
    }


}
