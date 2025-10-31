package com.gft.palavras_api.infra.security.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.gft.palavras_api.models.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Value;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {
    @Value("${api.security.token.secret-key}")
    private String secretKey;

    public String generateToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secretKey);

            String token = JWT.create()
                    .withIssuer("palavras-api")
                    .withSubject(user.getEmail())
                    .withClaim("role", user.getRole().name())
                    .sign(algorithm);
            return token;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar token JWT", e);
        }
    }

    public String validadeToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .withIssuer("palavras-api")
                    .build()
                    .verify(token);
            return decodedJWT.getClaim("role").asString();
        } catch (Exception e){
            throw new RuntimeException("Token JWT inválido ou expirado", e);
        }
    }

    public String getRoleFromToken(String token) {
        try{
            Algorithm algorithm = Algorithm.HMAC256(secretKey);
            DecodedJWT decodedJWT = JWT.require(algorithm)
                    .withIssuer("palavras-api")
                    .build()
                    .verify(token);
            return decodedJWT.getClaim("role").asString();
        } catch (Exception e){
            throw new RuntimeException("Token JWT inválido ou expirado", e);
        }
    }

    public Instant generateExpirationInstant(int minutes) {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.ofHours(-3));
    }
}
