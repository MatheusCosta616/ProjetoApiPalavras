package com.gft.palavras_api.usecase.user.impl;

import com.gft.palavras_api.dto.request.UserRequestDTO;
import com.gft.palavras_api.dto.response.UserResponseDTO;
import com.gft.palavras_api.models.User;
import com.gft.palavras_api.models.enums.Role;
import com.gft.palavras_api.repository.UserRepository;
import com.gft.palavras_api.usecase.user.CreateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateUserServiceImpl implements CreateUserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        User user = new User();
        user.setEmail(userRequestDTO.getEmail());
        user.setPassword(userRequestDTO.getPassword());
        user.setUsername(userRequestDTO.getName());
        user.setRole(Role.valueOf(userRequestDTO.getRole()));
        userRepository.save(user);

        UserResponseDTO response = new UserResponseDTO();
        response.setId(user.getId());
        response.setEmail(user.getEmail());
        response.setName(user.getUsername());
        response.setRole(user.getRole().name());

        return response;
    }
}
