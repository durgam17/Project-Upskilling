package com.example.demo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface Student2Repository extends MongoRepository<Student2, Integer> {
		 
		Optional<Student2> findById(String id);
	 
		void deleteById(String id);
	 
	

}
