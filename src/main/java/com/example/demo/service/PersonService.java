package com.example.demo.service;

import com.example.demo.model.PersonModel;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<PersonModel> findAll() {
        return personRepository.findAll();
    }

    public PersonModel findById(Integer id) {
        return personRepository.findById(id).orElseThrow(() -> new Error("Person error"));
    }

    public PersonModel save(PersonModel person) {
        return personRepository.save(person);
    }

    public void delete(Integer id) {
        personRepository.deleteById(id);
    }
}
