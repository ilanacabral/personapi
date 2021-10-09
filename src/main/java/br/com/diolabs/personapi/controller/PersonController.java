package br.com.diolabs.personapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.diolabs.personapi.dto.MessageResponseDTO;
import br.com.diolabs.personapi.dto.PersonDTO;
import br.com.diolabs.personapi.service.PersonService;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MessageResponseDTO createPerson(@Valid @RequestBody PersonDTO personDTO){        
         return personService.savePerson(personDTO);     
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PersonDTO> findAllPerson(){
        return personService.findAllPerson();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PersonDTO findPersonById(@Valid @PathVariable Long id){
       return  personService.findPersonById(id);        
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO deletePerson(@Valid @PathVariable Long id){
       return  personService.deletePerson(id);        
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MessageResponseDTO updatePerson(@Valid @PathVariable Long id, @Valid @RequestBody PersonDTO personDTO){        
         return personService.updatePerson(id,personDTO);     
    }
    
}
