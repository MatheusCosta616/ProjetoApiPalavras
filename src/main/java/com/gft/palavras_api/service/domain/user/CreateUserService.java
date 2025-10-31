package com.gft.palavras_api.service.domain.user;

import com.gft.palavras_api.dto.request.UserRequestDTO;
import com.gft.palavras_api.dto.response.UserResponseDTO;

public interface CreateUserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
}
