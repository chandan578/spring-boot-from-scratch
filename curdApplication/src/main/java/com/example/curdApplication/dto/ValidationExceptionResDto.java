package com.example.CurdApplication.dto;

import java.time.LocalDateTime;
import java.util.Map;

public class ValidationExceptionResDto {

    private LocalDateTime timeStamp;
    private int statusCode;
    private String message;
    private String path;
    private String error;
    private Map<String, String> fieldErrors;

    public ValidationExceptionResDto(LocalDateTime timeStamp, int statusCode, String message, String path, String error, Map<String, String> fieldErrors) {
        this.timeStamp = timeStamp;
        this.statusCode = statusCode;
        this.message = message;
        this.path = path;
        this.error = error;
        this.fieldErrors = fieldErrors;
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

    public Map<String, String> getFieldErrors() {
        return fieldErrors;
    }

    public void setFieldErrors(Map<String, String> fieldErrors) {
        this.fieldErrors = fieldErrors;
    }
}
