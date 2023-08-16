package com.lts.quanlykhoahoc.models.response;

public class ApiResponse<T> {
    private String timestamp;
    private int status;
    private String error;
    private String message;

    private T data;

    public ApiResponse(String timestamp, int status, String error, String message, T data) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public ApiResponse(String timestamp, int status, String error, String message) {
        this.timestamp = timestamp;
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }



    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

}
