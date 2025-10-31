package com.example.demo.config;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.HandlerMethodValidationException;

@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(HandlerMethodValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleHandlerValidation(HandlerMethodValidationException ex) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("mensaje", "JSON inválido");
        body.put("errores", ex.getAllErrors().stream()
            .map(err -> {
                String campo = (err instanceof FieldError fe) ? fe.getField() : ((ObjectError) err).getObjectName();
                return Map.of(
                    "campo", campo,  
                    "error", err.getDefaultMessage()
                );
            })
            .collect(Collectors.toList()));
        return body;
    }
}

