package com.smartqueue.smartqueue.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.smartqueue.smartqueue.dto.LoginRequest;
import com.smartqueue.smartqueue.dto.LoginResponse;
import com.smartqueue.smartqueue.entity.User;
import com.smartqueue.smartqueue.jwt.JwtUtil;
import com.smartqueue.smartqueue.service.UserService;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "http://localhost:5173")
public class AuthController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {

        User user = userService.loginUser(
                request.getEmail(),
                request.getPassword()
        );

        if (user == null) {
            return ResponseEntity.badRequest().body(
                    new LoginResponse("Invalid Email or Password", false)
            );
        }

        String token = jwtUtil.generateToken(user.getEmail());

        LoginResponse response = new LoginResponse(
                token,
                "Login Successful",
                true,
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {

        return ResponseEntity.ok(
                userService.registerUser(user)
        );
    }
}
