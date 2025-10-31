package com.gft.palavras_api.usecase.user;

import com.gft.palavras_api.dto.request.UserRequestDTO;
import com.gft.palavras_api.dto.response.UserResponseDTO;

public interface CreateUserService {
    UserResponseDTO createUser(UserRequestDTO userRequestDTO);
}
