package br.diolabs.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.diolabs.personapi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
