package com.example.demo;

	
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.*;

import java.util.List;
	import java.util.Optional;
	 
	@RestController
	@RequestMapping("/students")
	public class Student2Controller {
	 
	    @Autowired
	    private Student2Service studentService;
	 
	    @GetMapping
	    public List<Student2> getAllStudents() {
	        return studentService.getAllStudents();
	    }
	 
	    @GetMapping("/{id}")
	    public ResponseEntity<Student2> getStudentById(@PathVariable String id) {
	        Optional<Student2> student = studentService.getStudentById(id);
	        return student.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	    @PostMapping("/add")
	    public ResponseEntity<Student2> createStudent(@RequestBody Student2 student) {
	        Student2 createdStudent = studentService.createStudent(student);
	        return ResponseEntity.status(HttpStatus.CREATED).body(createdStudent);
	    }
	 
	    @PutMapping("put/{id}")
	    public ResponseEntity<Student2> updateStudent(@PathVariable String id, @RequestBody Student2 updatedStudent) {
	        Optional<Student2> updated = studentService.updateStudent(id, updatedStudent);
	        return updated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
	    }
	 
	    @DeleteMapping("/delete/{id}")
	    public ResponseEntity<Void> deleteStudent(@PathVariable String id) {
	        studentService.deleteStudent(id);
	        return ResponseEntity.noContent().build();
	    }
	

}
