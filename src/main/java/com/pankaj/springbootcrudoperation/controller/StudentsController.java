package com.pankaj.springbootcrudoperation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pankaj.springbootcrudoperation.model.Students;
import com.pankaj.springbootcrudoperation.service.StudentsService;

@RestController ////mark class as Controller  
public class StudentsController {
	
	//Checking connectivity
	@GetMapping("/ping")
	public String checkingConnectivity() {
		
		return "Great Pankaj! Ping Successful";
	}
	 
	@Autowired  // autowire the BooksService class 
	StudentsService studentsService;  
	
	//creating a get mapping that retrieves all the students detail from the database 
	//getAllStudents(): It returns a List of all Students.
	@GetMapping("/student")  
	public List<Students> getAllStudents()   
	{  
	return studentsService.getAllStudents();  
	}
	
	//creating a get mapping that retrieves the detail of a specific student by id  
	//getStudentss(): It returns a student detail that we have specified in the path variable. 
	//We have passed studentid as an argument by using the annotation @PathVariable. 
	//The annotation indicates that a method parameter should be bound to a URI template variable.
	@GetMapping("/student/{studentid}")  
	public Students getStudents(@PathVariable("studentid") int studentid)   
	{  
	return studentsService.getStudentsById(studentid);  
	}  
	
	
	//creating a delete mapping that deletes a specified student
	//deleteStudent(): It deletes a specific student that we have specified in the path variable.
	@DeleteMapping("/student/{studentid}")  
	public void deleteStudent(@PathVariable("studentid") int studentid)   
	{  
	studentsService.delete(studentid);  
	}  
	
	//creating post mapping that post the student detail in the database 
	//saveStudent(): It saves the book detail. 
	//The annotation @RequestBody indicates that a method parameter should be bound to the body of the web request.
	@PostMapping("/students")  
	public int saveStudent(@RequestBody Students students)   
	{  
	studentsService.saveOrUpdate(students);  
	return students.getStudentId();  
	}  
	
	
	//creating put mapping that updates the student detail 
	//update(): The method updates a record. We must specify the record in the body, which we want to update. 
	//To achieve the same, we have used the annotation @RequestBody.
	@PutMapping("/students")  
	public Students update(@RequestBody Students students)   
	{  
	studentsService.saveOrUpdate(students);  
	return students;  
	}  
	
	//creating a get mapping that retrieves List of Student of specified name  
	@GetMapping("/student/name/{studentName}")  
	public List<Students> getStudentsByName(@PathVariable("studentName") String  studentName)   
	{  
	return studentsService.getStudentsByName(studentName); 
	}  
	
	//creating a get mapping that retrieves List of Student of specified name  
	@GetMapping("/student/{nativePlace}/{studentName}")  
	public List<Students> getStudentsByNativePlace(@PathVariable("nativePlace") String nativePlace, @PathVariable("studentName") String studentName)   
	{  
		return studentsService.getStudentsByNativePlaceAndName(nativePlace, studentName); 
	} 
	
	//creating a get mapping that retrieves List of Student based on native place
	//To test custom Query
	//JPQL
		@GetMapping("/student/place/{nativePlace}")  
		public List<Students> getStudentsByNativePlace(@PathVariable("nativePlace") String nativePlace)   
		{  
			return studentsService.getStudentsByNativePlace(nativePlace); 
		} 
	

}
