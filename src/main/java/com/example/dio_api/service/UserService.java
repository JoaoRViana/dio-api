package com.example.dio_api.service;

import org.springframework.stereotype.Service;

import com.example.dio_api.Repository.UserRepository;
import com.example.dio_api.domain.model.User;

@Service
public class UserService {

    private final UserRepository userRepository = null;

    public User CreateUser(User createUser) throws IllegalAccessException{
        if(userRepository.existsAccount(createUser.getAccount().getNumber())){
            throw new IllegalAccessException("This account number already exists");
        }
        return userRepository.save(createUser);
    }
}
