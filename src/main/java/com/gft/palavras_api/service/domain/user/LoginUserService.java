package com.gft.palavras_api.service.domain.user;

import com.gft.palavras_api.dto.request.LoginRequestDTO;
import org.springframework.http.ResponseEntity;

public interface LoginUserService {
    ResponseEntity<?> login(LoginRequestDTO loginRequestDTO);
}
