package com.demo.assignment.hyperhire.controller;

import com.demo.assignment.hyperhire.model.dto.UserDto;
import com.demo.assignment.hyperhire.model.request.LoginRequest;
import com.demo.assignment.hyperhire.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping(value = "/login")
    public UserDto login(@RequestBody LoginRequest request){
        return userService.login(request);
    }

}
