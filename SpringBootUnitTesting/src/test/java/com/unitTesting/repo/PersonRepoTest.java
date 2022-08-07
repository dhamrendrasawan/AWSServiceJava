package com.unitTesting.repo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.unitTesting.entities.Person;

@SpringBootTest
class PersonRepoTest {

	@Autowired
	PersonRepo personRepo;
	
	@Test
	void isPersonExitsById() {
		
		Person person=new Person(90,"Sawan","bihar");
		personRepo.save(person);
		
		boolean actual=personRepo.isPersonExitsById(90);
		assertThat(actual).isTrue();
	}
	
	@Test
	void isPersonnotExitsById() {	
		
		boolean actual=personRepo.isPersonExitsById(9000);
		assertThat(actual).isFalse();
	}
	
	@AfterEach
	void tearDown() throws Exception {
		
		System.out.println("Tear Down");
		personRepo.deleteAll();
	}
	
	@BeforeEach
	void setUp() throws Exception {
		System.out.println("Setting Up");
	}
	
}
