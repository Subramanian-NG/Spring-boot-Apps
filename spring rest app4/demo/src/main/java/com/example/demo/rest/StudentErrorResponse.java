package com.example.demo.rest;

public class StudentErrorResponse {
    private String errorMessage;
    private int status;
    private Long timeStamp;

    public StudentErrorResponse(String errorMessage, int status, Long timeStamp) {
        this.errorMessage = errorMessage;
        this.status = status;
        this.timeStamp = timeStamp;
    }

    public String getErrorMessage() {
        return this.errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Long getTimeStamp() {
        return this.timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }

}
