package com.demo.assignment.hyperhire.service;

import com.demo.assignment.hyperhire.model.dto.UserDto;
import com.demo.assignment.hyperhire.model.request.LoginRequest;
import org.springframework.stereotype.Component;

@Component
public interface UserService {

    public UserDto login(LoginRequest email);

}
