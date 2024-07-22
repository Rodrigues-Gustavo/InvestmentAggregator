package com.gustavorodrigues.investmentAggregator.service;

import com.gustavorodrigues.investmentAggregator.controller.dto.CreateUserDto;
import com.gustavorodrigues.investmentAggregator.entity.User;
import com.gustavorodrigues.investmentAggregator.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UUID createUser(CreateUserDto createUserDto) {

        var entity = new User(
                UUID.randomUUID(),
                createUserDto.username(),
                createUserDto.email(),
                createUserDto.password(),
                Instant.now(),
                null);

        var userSaved = userRepository.save(entity);

        return userSaved.getUserId();
    }
}