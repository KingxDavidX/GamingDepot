package com.example.transactions.dto;

public record ApiError() implements ApiResponse {
    private String Error;

    public ApiError() {}

    public ApiError(String Error) {
        this.Error = Error;
    }

    public String getError() {return this.Error;}

    public void setError(String Error) {this.Error = Error;}


}
