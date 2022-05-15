package com.thecodeschool.security.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtUtils {
    private final static String KEY = "5DD5ECDF16C2D5DCCFD7B933AD8AE88CE42735C9F98FEC123E3BBDC5C6";

    public String generateToken(UserDetails userDetails) {
        return Jwts.builder()
                .claim("name", userDetails.getUsername())
                .setSubject("auth-token")
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(Instant.now()))
                .setExpiration(Date.from(Instant.now().plus(5l, ChronoUnit.MINUTES)))
                .signWith(SignatureAlgorithm.HS256, KEY)
                .compact();
    }

    public String extractUsername(String jwtToken) {
        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(jwtToken)
                .getBody()
                .get("name", String.class);
    }

    public boolean validateToken(String jwtToken) {

        return Jwts.parserBuilder()
                .setSigningKey(KEY)
                .build()
                .parseClaimsJws(jwtToken)
                .getBody()
                .getExpiration()
                .after(new Date());
    }
}
