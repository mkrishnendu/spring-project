package com.example.usermanagementsystem.response;

public class LoginResponse {

    private String message;
    private boolean status; // Change status to boolean

    public LoginResponse(String message, boolean status) {
        this.message = message;
        this.status = status; // Directly assign the boolean value
    }

    public LoginResponse() {
        // Default constructor
    }

    public String getMessage() {
        return message;
    }

    public boolean isStatus() { // Use isStatus() for boolean
        return status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setStatus(boolean status) { // Change to boolean parameter
        this.status = status;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "message='" + message + '\'' +
                ", status=" + status + // Print boolean directly
                '}';
    }
}
