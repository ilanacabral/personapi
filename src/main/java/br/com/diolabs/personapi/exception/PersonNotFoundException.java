package br.com.diolabs.personapi.exception;

public class PersonNotFoundException extends RuntimeException{

    public PersonNotFoundException(Long id) {
        super("Person ID " + id + " not found.");
    }
    
}
