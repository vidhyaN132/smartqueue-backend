package com.smartqueue.smartqueue.dto;

public class LoginResponse {

    private String token;
    private String message;
    private boolean success;
    private Long userId;
    private String name;
    private String email;
    private String role;

    // Default Constructor
    public LoginResponse() {
    }

    // Error Response Constructor
    public LoginResponse(String message, boolean success) {
        this.message = message;
        this.success = success;
    }

    // Success Constructor
    public LoginResponse(
            String token,
            String message,
            boolean success,
            Long userId,
            String name,
            String email,
            String role) {

        this.token = token;
        this.message = message;
        this.success = success;
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}