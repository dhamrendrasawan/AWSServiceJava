package com.unitTesting.services;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.unitTesting.repo.PersonRepo;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
class PersonServiceTest {

	@Mock
	PersonRepo personRepo;
	
	 private  PersonService personService;

	@Test
	void testGetAllPerson() {
		 
		personService.getAllPerson();
		verify(personRepo).findAll();
		
	}

	@BeforeEach
	void setUp() throws Exception {
		this.personService=new PersonService(this.personRepo);
	}
}
