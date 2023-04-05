package com.pankaj.springbootcrudoperation.model;

import org.hibernate.annotations.NamedQueries;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity() //mark class as an Entity  
@Table //defining class name as Table name 
public class Students {
	@Id //Defining studentId as primary key  
	@Column
	private int studentId;
	
	@Column
	private String studentName;
	
	@Column
	private String nativePlace;
	
	//Constructor
	public Students(int studentId, String studentName, String nativePlace) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.nativePlace = nativePlace;
	}
	public Students() {}

	//Getters and Setters
	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}
	
	
	
	

}
