package com.example.tienda.controller;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UsuarioNotFoundException extends RuntimeException {
    
    public UsuarioNotFoundException(String message){
        super(message);
    }

}
