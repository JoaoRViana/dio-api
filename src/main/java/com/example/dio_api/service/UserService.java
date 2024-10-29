package com.example.dio_api.service;

import org.springframework.stereotype.Service;

import com.example.dio_api.Repository.UserRepository;
import com.example.dio_api.domain.model.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User CreateUser(User createUser) throws IllegalAccessException{
        if(userRepository.existsByAccount_Number(createUser.getAccount().getNumber())){
            throw new IllegalAccessException("This account number already exists");
        }
        return userRepository.save(createUser);
    }
}
