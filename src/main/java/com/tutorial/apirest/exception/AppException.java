package com.tutorial.apirest.exception;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException{

    private final HttpStatus status;

    public AppException(String mensaje, HttpStatus status){
        super(mensaje);
        this.status = status;
    }

    public HttpStatus getStatus(){return status;}
}
