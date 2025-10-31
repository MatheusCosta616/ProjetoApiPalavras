package com.gft.palavras_api.usecase.user;

import com.gft.palavras_api.dto.request.LoginRequestDTO;
import org.springframework.http.ResponseEntity;

public interface LoginUserService {
    ResponseEntity<?> login(LoginRequestDTO loginRequestDTO);
}
