package com.example.dio_api.controllers;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dio_api.Repository.UserRepository;
import com.example.dio_api.domain.model.User;
import com.example.dio_api.service.UserService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserRepository userRepository;


    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUser(@PathVariable Long id){
        Optional<User> user = this.userRepository.findById(id);
        if(user.isEmpty()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(user);
    }
    
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user) throws IllegalAccessException{
        User userCreated = this.userService.CreateUser(user);
        this.userRepository.save(userCreated);
        return ResponseEntity.ok(userCreated);

    }

}
