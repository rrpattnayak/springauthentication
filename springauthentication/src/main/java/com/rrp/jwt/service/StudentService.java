package com.rrp.jwt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rrp.jwt.dao.StudentRepository;
import com.rrp.jwt.entity.Student;

@Service
public class StudentService {
	
	@Autowired
    private StudentRepository studentRepository;
	
	public Student save(Student student) {
        return studentRepository.save(student);
    }
    
    public List<Student> findAll() {
        return studentRepository.findAll();
    }
    
    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
    
    public Student findByStudentName(String studentName) {
        return studentRepository.findByStudentName(studentName);
    }
    
    public void deleteById(Long id) {
    	studentRepository.deleteById(id);
    }

}
