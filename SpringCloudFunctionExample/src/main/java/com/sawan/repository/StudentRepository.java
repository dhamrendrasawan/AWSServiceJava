package com.sawan.repository;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.sawan.entity.Student;

@Repository
public class StudentRepository {

	public List<Student> studentList()
	{
		return Arrays.asList(
				new Student(1,"Sawan",20),
				new Student(2,"Raja",30),
				new Student(3,"Ramu",40),
				new Student(4,"Mohan",50)
				);		
	 }
}
