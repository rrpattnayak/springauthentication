package com.rrp.jwt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class Student {
	
	@Column(name = "student_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Id
	private Long studentId;
	
	@Column(name = "student_name")
	private String studentName;
	
	@Column(name = "student_age")
	private String studentAge;
	
	@Column(name = "student_batch_code")
	private String studentBatchCode;
	
	
}
