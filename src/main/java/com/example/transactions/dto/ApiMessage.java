package com.example.transactions.dto;

public record ApiMessage() implements ApiResponse {
    private String message;

    public ApiMessage() {}

    public ApiMessage(String Message) {
        this.message = Message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
