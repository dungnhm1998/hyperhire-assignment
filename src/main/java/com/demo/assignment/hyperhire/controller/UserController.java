package com.demo.assignment.hyperhire.controller;

import com.demo.assignment.hyperhire.model.dto.UserDto;
import com.demo.assignment.hyperhire.model.request.LoginRequest;
import com.demo.assignment.hyperhire.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/login")
    public UserDto login(@RequestBody LoginRequest request){
        return userService.login(request);
    }


    @PostMapping(value = "/register")
    public UserDto register(@RequestBody LoginRequest request){
        return userService.register(request);
    }

}
