package br.diolabs.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.diolabs.personapi.repository.PersonRepository;
import java.util.List;

import br.diolabs.personapi.dto.MessageResponseDTO;
import br.diolabs.personapi.model.*;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;
    
    public MessageResponseDTO savePerson(Person person){   
        personRepository.save(person);
        return  MessageResponseDTO.builder().message("Person created with ID " + person.getId()).build();  
    }

    public List<Person> findAllPerson(){
        return personRepository.findAll();
    }
    
}
