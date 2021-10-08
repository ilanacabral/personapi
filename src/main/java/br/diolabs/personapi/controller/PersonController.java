package br.diolabs.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.diolabs.personapi.service.PersonService;
import br.diolabs.personapi.dto.MessageResponseDTO;
import br.diolabs.personapi.model.Person;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@Valid @RequestBody Person person){        
         return personService.savePerson(person);     
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Person> findAllPerson(){
        return personService.findAllPerson();
    }
    
}
