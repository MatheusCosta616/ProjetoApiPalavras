package com.gft.palavras_api.service.domain.user;

import com.gft.palavras_api.dto.request.UserRequestDTO;
import com.gft.palavras_api.dto.response.UserResponseDTO;
import org.springframework.http.ResponseEntity;

public interface RegisterUserService {
    ResponseEntity<?> registerUser(UserRequestDTO userRequestDTO);
}
