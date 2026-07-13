package com.smartqueue.smartqueue.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smartqueue.smartqueue.entity.User;
import com.smartqueue.smartqueue.repository.UserRepository;


@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;


    // Register User
    public User registerUser(User user) {

        if(userRepository.findByEmail(user.getEmail()) != null) {
            return null;
        }

        return userRepository.save(user);
    }


    // Login User
    public User loginUser(String email, String password) {

        User user = userRepository.findByEmail(email);

        if(user != null && user.getPassword().equals(password)) {

            return user;

        }

        return null;
    }


    // Get User By ID
    public User getUserById(Long id) {

        return userRepository.findById(id).orElse(null);

    }


    // Get All Users (Admin)
    public List<User> getAllUsers() {

        return userRepository.findAll();

    }

}