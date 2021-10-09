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

    private PersonMapper personMapper = PersonMapper.INSTANCE;

    public MessageResponseDTO savePerson(PersonDTO personDTO) {
        Person person = personRepository.save(personMapper.toModel(personDTO));
        return MessageResponseDTO.builder().message("Person created with ID " + person.getId()).build();
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
        return MessageResponseDTO.builder().message("Person ID " + id + " deleted with success.").build();
    }

    public MessageResponseDTO updatePerson(@Valid Long id, @Valid PersonDTO personDTO) {

        PersonDTO personToUpdate = this.findPersonById(id);
        personToUpdate.setFirstName(personDTO.getFirstName());
        personToUpdate.setLastName(personDTO.getLastName());
        personToUpdate.setCpf(personDTO.getCpf());
        personToUpdate.setBirthDate(personDTO.getBirthDate());
        personToUpdate.setPhones(personDTO.getPhones());

        personRepository.save(personMapper.toModel(personToUpdate));

        return MessageResponseDTO.builder().message("Person ID " + id + " updated with success.").build();
    }

}
