package com.example.demo;
	
	import org.slf4j.Logger;
	import org.slf4j.LoggerFactory;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	 
	import java.math.BigDecimal;
	import java.util.List;
	import java.util.Optional;
	 
	@Service
	public class Student2Service {
	 
	    private final Logger log = LoggerFactory.getLogger(Student2Service.class);
	 
	    @Autowired
	    private Student2Repository studentRepository;
	 
	    public List<Student2> getAllStudents() {
	        return studentRepository.findAll();
	    }
	 
	    public Optional<Student2> getStudentById(String id) {
	        return studentRepository.findById(id);
	    }
	 
	    public Student2 createStudent(Student2 student) {
	log.info("Creating a new student: {}", student);
	        return studentRepository.save(student);
	    }
	 
	    public Optional<Student2> updateStudent(String id, Student2 updatedStudent) {
	log.info("Updating student with ID {}: {}", id, updatedStudent);
	        Optional<Student2> existingStudent = studentRepository.findById(id);
	        if (existingStudent.isPresent()) {
	            Student2 updated = existingStudent.get();
	            updated.setName(updatedStudent.getName());
	            updated.setAge(updatedStudent.getAge());
	            updated.setSalary(updatedStudent.getSalary());
	            return Optional.of(studentRepository.save(updated));
	        }
	        return Optional.empty();
	    }
	 
	    public void deleteStudent(String id) {
	log.info("Deleting student with ID: {}", id);
	        studentRepository.deleteById(id);
	    }
	

}
