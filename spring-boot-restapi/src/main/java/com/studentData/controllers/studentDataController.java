package com.studentData.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.studentData.models.studentdb;
import com.studentData.service.studentdbService;

@SpringBootApplication
@RestController
@RequestMapping("studentData-restapi")
public class studentDataController {
	
	//welcome page - query to display a message
	
	//http:localhost:8080/studentData-restapi/welcome	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome to the student query database";
	}
	
	@Autowired
	public studentdbService studentdbService;
	
	@CrossOrigin(origins="http://localhost:4200")
	//http://localhost:8080/studentData-restapi/all-names
	@GetMapping("/all-names")													// send a query to view all the name emtries
	public List<studentdb> AllNames(){
		return this.studentdbService.AllNames();
	}
	
	//http://localhost:8080/studentData-restapi/name-by-rollno/1
	@GetMapping("/name-by-rollno/{Rollno}")										//send a query to get a specific entry by roll no
	public studentdb getByRollno(@PathVariable("Rollno") int rollno){
		return studentdbService.getByRollno(rollno);
	}
	
	//localhost:8080/studentData-restapi/all-names
	@PostMapping("/all-names")													//send a query to add a new entry
	public studentdb AddStudent(@RequestBody studentdb StudentDb) {	
		return this.studentdbService.AddStudent(StudentDb);
	}
	
	//localhost:8080/studentData-restapi/all-names/4
	@PutMapping("/all-names/{Rollno}")											// send a query to update an existing entry
	public studentdb UpdateStudent(@PathVariable("Rollno") String rollno, @RequestBody studentdb update) {
		this.studentdbService.DeleteStudent(Long.parseLong(rollno));
		return this.studentdbService.AddStudent(update);
	}
	
	//localhost:8080/studentData-restapi/all-names/3
	@DeleteMapping("/all-names/{rollno}")										//send a query to delete and entry
	public ResponseEntity<HttpStatus> DeleteStudent(@PathVariable String rollno) {
		try {
			this.studentdbService.DeleteStudent(Long.parseLong(rollno));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}	
}
