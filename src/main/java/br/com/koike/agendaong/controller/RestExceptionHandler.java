package br.com.koike.agendaong.controller;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.ResponseEntity.status;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.koike.agendaong.security.jwt.InvalidJwtAuthenticationException;

@RestControllerAdvice
public class RestExceptionHandler {


    @ExceptionHandler(value = {InvalidJwtAuthenticationException.class})
    public ResponseEntity invalidJwtAuthentication(InvalidJwtAuthenticationException ex, WebRequest request) {
        //log.debug("handling InvalidJwtAuthenticationException...");
        System.out.println("handling InvalidJwtAuthenticationException...");
        return status(UNAUTHORIZED).build();
    }
}

