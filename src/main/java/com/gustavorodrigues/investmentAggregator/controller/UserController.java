package com.gustavorodrigues.investmentAggregator.controller;

import com.gustavorodrigues.investmentAggregator.controller.dto.CreateUserDto;
import com.gustavorodrigues.investmentAggregator.entity.User;
import com.gustavorodrigues.investmentAggregator.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserDto createUserDto) {
        var userid = userService.createUser(createUserDto);
        return ResponseEntity.created(URI.create("/v1/users/" + userid.toString())).build();
    }
}