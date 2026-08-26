package com.applyflow.service;

import org.springframework.stereotype.Service;

import com.applyflow.entity.User;
import com.applyflow.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User saveUser(User user) {
        return userRepository.save(user);
    }
}