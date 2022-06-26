package com.studentData.service;

//import java.util.Arrays;
import java.util.List;

import com.studentData.models.studentdb;

public interface studentdbService{
	studentdb getByRollno(int rollno);
	public List<studentdb> AllNames();
	public studentdb AddStudent(studentdb StudentDb);
	void DeleteStudent(long parseLong);
	studentdb UpdateStudent(int rollno, studentdb update);
}