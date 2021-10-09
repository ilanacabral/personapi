package br.com.diolabs.personapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.diolabs.personapi.dto.MessageResponseDTO;
import br.com.diolabs.personapi.exception.PersonNotFoundException;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(PersonNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageResponseDTO notFound(){
        return MessageResponseDTO.builder().message("Person not found.").build();
    }
    
}
