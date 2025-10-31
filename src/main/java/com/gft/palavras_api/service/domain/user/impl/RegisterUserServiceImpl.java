package com.gft.palavras_api.service.domain.user.impl;

import com.gft.palavras_api.dto.request.UserRequestDTO;
import com.gft.palavras_api.models.User;
import com.gft.palavras_api.repository.UserRepository;
import com.gft.palavras_api.service.domain.user.CreateUserService;
import com.gft.palavras_api.service.domain.user.RegisterUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserServiceImpl implements RegisterUserService {
    private final UserRepository userRepository;
    private final CreateUserService createUserService;

    public RegisterUserServiceImpl(UserRepository userRepository, CreateUserService createUserService) {
        this.userRepository = userRepository;
        this.createUserService = createUserService;
    }

    @Override
    public ResponseEntity<?> registerUser(UserRequestDTO userRequestDTO) {
       try {
           if(userRepository.findByEmail(userRequestDTO.getEmail()).isPresent()){
               return ResponseEntity.badRequest().body("Email já cadastrado.");
           }
           return new ResponseEntity<>(createUserService.createUser(userRequestDTO), HttpStatus.CREATED);
       } catch (Exception e) {
           return ResponseEntity.badRequest().body("NAO FOI POSSIVEL CRIAR O USUARIO: " + e.getMessage());
       }
    }
}
