package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;


import org.junit.jupiter.api.Test;

 
public class StudentTest {
 
    @Test
    public void testStudentDetails() {
        // Create a new student
        Student student = new Student();
        student.setName("Priya");
        student.setAge(23);
        student.setSalary(6000);
 
        // Test student details
        assertEquals("Priya", student.getName());
        assertEquals(23, student.getAge());
        assertEquals(6000, student.getSalary());
    }
}