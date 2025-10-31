package com.gft.palavras_api.usecase.user.impl;

import com.gft.palavras_api.dto.request.LoginRequestDTO;
import com.gft.palavras_api.infra.security.service.TokenService;
import com.gft.palavras_api.models.User;
import com.gft.palavras_api.repository.UserRepository;
import com.gft.palavras_api.usecase.user.LoginUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class LoginUserServiceImpl implements LoginUserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private TokenService tokenService;

    @Override
    public ResponseEntity<?> login(LoginRequestDTO loginRequestDTO) {
        User user = getUser(loginRequestDTO);

        if(passwordEncoder.matches(loginRequestDTO.password(), user.getPassword())){
            String token = tokenService.generateToken(user);
            return ResponseEntity.ok(new LoginRequestDTO(user.getUsername(), token));
        }
        return ResponseEntity.badRequest().body("Invalid credentials");
    }

    private User getUser(LoginRequestDTO loginRequestDTO) {
        User user = userRepository.findByEmail(loginRequestDTO.email())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado com email: " + loginRequestDTO.email()));
        return user;
    }
}
