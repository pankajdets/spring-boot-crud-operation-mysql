package com.pankaj.springbootcrudoperation.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pankaj.springbootcrudoperation.model.Students;
import com.pankaj.springbootcrudoperation.repository.StudentsRepository;

////defining the business logic 
@Service
public class StudentsService {
	
	@Autowired  
	StudentsRepository studentsRepository;  
	
	//getting all students record by using the method findaAll() of CrudRepository  
	public List<Students> getAllStudents()   
	{  
	List<Students> students = new ArrayList<Students>();  
	studentsRepository.findAll().forEach(students1 -> students.add(students1));  
	return students;  
	}  
	
	//getting a specific record by using the method findById() of CrudRepository  
	public Students getStudentsById(int id)   
	{  
	return studentsRepository.findById(id).get();  
	}  
	
	//saving a specific record by using the method save() of CrudRepository  
	public void saveOrUpdate(Students students)   
	{  
	studentsRepository.save(students);  
	}  
	
	//deleting a specific record by using the method deleteById() of CrudRepository  
	public void delete(int id)   
	{  
	studentsRepository.deleteById(id);  
	}  
	
	//updating a record  
	public void update(Students students, int studentid)   
	{  
		studentsRepository.save(students);  
	}  
	
	//Customer Finder Methods/ Drived Query Methods
	//find student by name
	public List<Students> getStudentsByName(String name){
		return studentsRepository.findByStudentName(name);
	}
	//Customer Finder Methods/ Drived Query Methods
	//find student by native place
	public List<Students> getStudentsByNativePlaceAndName(String nativePlace, String name){
		return studentsRepository.findByNativePlaceAndStudentName(nativePlace, name);
	}
	
	//Customer Query JPQL
	//find student by nativePlace
	public List<Students> getStudentsByNativePlace(String nativePlace){
		return studentsRepository.getStudentsByNativePlace(nativePlace);
	}
	
	

}
