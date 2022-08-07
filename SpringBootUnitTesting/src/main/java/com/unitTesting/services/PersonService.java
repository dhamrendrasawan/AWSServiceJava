package com.unitTesting.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unitTesting.entities.Person;
import com.unitTesting.repo.PersonRepo;

import java.util.List;

@Service
public class PersonService {
    @Autowired
    private PersonRepo repo;
    
  

    public List<Person> getAllPerson() {
        return this.repo.findAll();
    }

    public PersonService(PersonRepo repo) {
        this.repo = repo;
    }
}
