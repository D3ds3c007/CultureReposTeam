package com.culture.API.Security;


import java.util.Date;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtUtil {

    // Define your secret key as a string
    private static final String SECRET_STRING = "Raitra123##@@VipFiorenana##@@Vip";

    // Convert the secret string to byte[]
    private static final byte[] SECRET_KEY_BYTES = SECRET_STRING.getBytes();

    public static Claims extractClaims(String token) {
        return Jwts.parser().setSigningKey(SECRET_KEY_BYTES).parseClaimsJws(token).getBody();
    }

    public static boolean validateToken(String token) {
        try {
            Claims claims = extractClaims(token);
            Date expiration = claims.getExpiration();
            return !expiration.before(new Date());
        } catch (Exception e) {
            return false; // Token validation failed
        }
    }

    public static String generateToken(int userId, String username, String email) {

        return Jwts.builder()
        .setSubject(createSubject(userId, username, email))
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
        .signWith(SignatureAlgorithm.HS256, SECRET_KEY_BYTES)
        .compact();
    }

    public static String[] extractUserInfo(String token) {
        String subject = extractClaims(token).getSubject();
        return subject.split("\\|"); // Split subject based on the delimiter
    }

    private static String createSubject(int userId, String username, String email) {
        return userId + "|" + username + "|" + email;
    }

    
}
