package br.com.diolabs.personapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.diolabs.personapi.dto.MessageResponseDTO;
import br.com.diolabs.personapi.dto.PersonDTO;
import br.com.diolabs.personapi.exception.PersonNotFoundException;
import br.com.diolabs.personapi.mapper.PersonMapper;
import br.com.diolabs.personapi.model.Person;
import br.com.diolabs.personapi.repository.PersonRepository;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PersonMapper personMapper;

    public MessageResponseDTO savePerson(PersonDTO personDTO) {
        Person person = personRepository.save(personMapper.toModel(personDTO));
        return messageResponseDTO("Person created with ID " + person.getId());
    }

    public List<PersonDTO> findAllPerson() {
        List<Person> allPerson = personRepository.findAll();
        return allPerson.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findPersonById(Long id) {
        Person person = personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
        return personMapper.toDTO(person);
    }    

    public MessageResponseDTO deletePerson(@Valid Long id) {
        this.findPersonById(id);
        personRepository.deleteById(id);
        return messageResponseDTO("Person with ID " + id + " deleted with success.");
    }

    public MessageResponseDTO updatePerson(@Valid Long id, @Valid PersonDTO personDTO) {
       this.findPersonById(id); 
       personRepository.save(personMapper.toModel(personDTO));
        return messageResponseDTO("Person with ID " + id + " updated with success.");
    }

    private MessageResponseDTO messageResponseDTO(String mensagem) {
        return MessageResponseDTO.builder().message(mensagem).build();
    }

}
