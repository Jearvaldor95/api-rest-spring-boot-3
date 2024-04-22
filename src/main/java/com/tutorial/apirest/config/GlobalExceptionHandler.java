package com.tutorial.apirest.config;

import com.tutorial.apirest.exception.AppException;
import com.tutorial.apirest.dto.ErrorDto;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> response(AppException exception){
        return ResponseEntity
                .status(exception.getStatus())
                .body(new ErrorDto(exception.getMessage()));
    }
    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseBody
    public ResponseEntity<ErrorDto> responseEntity(ConstraintViolationException exception){
        String errorMensaje = "Error de validacion: "+exception.getConstraintViolations()
                .stream()
                .map(constraintViolation -> constraintViolation.getPropertyPath() + " "+constraintViolation.getMessage())
                .collect(Collectors.joining(", "));

        return ResponseEntity.badRequest().body(new ErrorDto(errorMensaje));
    }
}
