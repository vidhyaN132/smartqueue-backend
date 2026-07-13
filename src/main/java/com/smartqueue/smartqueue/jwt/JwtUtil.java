package com.smartqueue.smartqueue.jwt;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    private static final String SECRET_KEY =
            "SmartQueueSecretKeySmartQueueSecretKey12345";

    private static final long EXPIRATION_TIME =
            1000 * 60 * 60 * 24; // 24 Hours

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    // Generate JWT Token
    public String generateToken(String email) {

        return Jwts.builder()
                .setSubject(email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    // Extract Email
    public String extractUsername(String token) {

        return extractClaims(token).getSubject();
    }

    // Extract All Claims
    public Claims extractClaims(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Validate Token
    public boolean validateToken(String token, String email) {

        try {

            String username = extractUsername(token);

            return username.equals(email)
                    && !extractClaims(token).getExpiration().before(new Date());

        } catch (JwtException | IllegalArgumentException e) {

            return false;

        }

    }

    // Extract Token From Authorization Header
    public String extractTokenFromHeader(String authHeader) {

        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return authHeader.substring(7);
        }

        return null;
    }

}