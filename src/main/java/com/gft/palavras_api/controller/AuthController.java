package com.gft.palavras_api.controller;

import com.gft.palavras_api.dto.request.LoginRequestDTO;
import com.gft.palavras_api.dto.request.UserRequestDTO;
import com.gft.palavras_api.service.domain.user.LoginUserService;
import com.gft.palavras_api.service.domain.user.RegisterUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final LoginUserService loginUserService;
    private final RegisterUserService registerUserService;

    public AuthController(LoginUserService loginUserService, RegisterUserService registerUserService) {
        this.loginUserService = loginUserService;
        this.registerUserService = registerUserService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest){
        return loginUserService.login(loginRequest);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody UserRequestDTO userRequest){
        return registerUserService.registerUser(userRequest);
    }
}
