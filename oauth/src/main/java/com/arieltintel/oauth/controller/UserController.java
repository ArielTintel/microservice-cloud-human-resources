package com.arieltintel.oauth.controller;

import com.arieltintel.oauth.dto.UserDto;
import com.arieltintel.oauth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{email}/email")
    @ResponseStatus(HttpStatus.OK)
    public UserDto findByEmail(@PathVariable String email) {
        return userService.findByEmail(email);
    }
}
