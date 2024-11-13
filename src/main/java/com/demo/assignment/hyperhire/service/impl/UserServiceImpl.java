package com.demo.assignment.hyperhire.service.impl;

import com.demo.assignment.hyperhire.model.dto.UserDto;
import com.demo.assignment.hyperhire.model.entity.User;
import com.demo.assignment.hyperhire.model.exception.BadRequestException;
import com.demo.assignment.hyperhire.model.exception.ServerError;
import com.demo.assignment.hyperhire.model.request.LoginRequest;
import com.demo.assignment.hyperhire.repository.UserRepository;
import com.demo.assignment.hyperhire.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDto login(LoginRequest request) {
        User user = userRepository.findByEmailAndPassword(request.getEmail(), request.getPassword())
                .orElseThrow(() -> new BadRequestException(ServerError.NOT_FOUND_USER));

        return UserDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName())
                .build();
    }
}
