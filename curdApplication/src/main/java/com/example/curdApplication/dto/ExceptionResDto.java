package com.example.CurdApplication.dto;

import java.time.LocalDateTime;

public class ExceptionResDto {

    private LocalDateTime timeStamp;
    private int statusCode;
    private String message;
    private String path;
    private String error;

    public ExceptionResDto(LocalDateTime timeStamp, int statusCode, String error, String message, String path) {
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
        this.error = error;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
