package com.rrp.jwt.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rrp.jwt.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	Student findByStudentId(String studentId);
	Student findByStudentName(String studentName);
}
