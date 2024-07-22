package com.rrp.jwt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rrp.jwt.entity.Student;
import com.rrp.jwt.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	@GetMapping("/getAllStudents")
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable(value = "id") Long studentId) {
    	Student Student = studentService.findById(studentId);
        if(Student == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(Student);
    }
    
    @PostMapping("/createStudent")
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable(value = "id") Long studentId,
                                           @RequestBody Student studentDetails) {
    	Student student = studentService.findById(studentId);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        student.setStudentName(studentDetails.getStudentName());
        student.setStudentAge(studentDetails.getStudentAge());
        student.setStudentBatchCode(studentDetails.getStudentBatchCode());
        Student updatedStudent = studentService.save(student);
        return ResponseEntity.ok(updatedStudent);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteStudent(@PathVariable(value = "id") Long studentId) {
        Student student = studentService.findById(studentId);
        if(student == null) {
            return ResponseEntity.notFound().build();
        }
        studentService.deleteById(studentId);
        return ResponseEntity.ok().build();
    }
}
