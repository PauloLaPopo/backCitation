package com.example.backcitation.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtTokenUtil {

    private final String secretKey = "your-secret-key"; // Changez ceci avec votre clé secrète

    public String generateToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        byte[] keyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        SecretKeySpec secretKeySpec = new SecretKeySpec(keyBytes, SignatureAlgorithm.HS512.getJcaName());
        System.out.println(secretKeySpec);
        String t =  Jwts.builder()
                .setClaims(claims)
                .setSubject(email)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Token valable 10 heures
                .signWith(SignatureAlgorithm.HS512, secretKeySpec)
                .compact();
        System.out.println(t);
        return "";
    }
}

