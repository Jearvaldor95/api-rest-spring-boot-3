package com.tutorial.apirest.dto;

public class ErrorDto {

    private String mensaje;

    public ErrorDto(String mensaje){
        this.mensaje = mensaje;
    }

    public String getMensaje(){return mensaje;}
}
