package br.com.diolabs.personapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.diolabs.personapi.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{
    
}
