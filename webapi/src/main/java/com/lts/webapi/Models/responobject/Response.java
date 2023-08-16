package com.lts.webapi.Models.responobject;

public class Response<T>{
    private int status;
    private String error;


    private String message;
    private T data;

    public Response(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }

    public Response(int status, String error, String message, T data) {
        this.status = status;
        this.error = error;
        this.message = message;
        this.data = data;
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
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
