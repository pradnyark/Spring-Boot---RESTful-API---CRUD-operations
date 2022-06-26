package com.studentData.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.studentData.models.studentdb;

@Service
public class StudentDbImpl implements studentdbService {

	List <studentdb> list;
	
	public StudentDbImpl() {
		list = new ArrayList<>();
		list.add(new studentdb("Ananya", "Karnik",1));
		list.add(new studentdb("Vrunda", "Khare",2));
		list.add(new studentdb("Mansi", "Kothari",3));
		list.add(new studentdb("Pradnya", "Kanale",4));
		list.add(new studentdb("Aditi", "Oak",5));
	}
	
	public List<studentdb> AllNames() {
		return list;
	}
	
	@Override
	public studentdb getByRollno(int rollno) {
		// TODO Auto-generated method stub
		return AllNames().stream().filter((studentdb)->studentdb.getRollno()==rollno).findAny().orElse(new studentdb());
	}

	@Override
	public studentdb AddStudent(studentdb StudentDb) {
		// TODO Auto-generated method stub
		list.add(StudentDb);
		return StudentDb;
	}

	@Override
	public void DeleteStudent(long parseLong) {
		// TODO Auto-generated method stub
		list = this.list.stream().filter(e->e.getRollno()!=parseLong).collect(Collectors.toList());
	}

	@Override
	public studentdb UpdateStudent(int rollno, studentdb update) {
		// TODO Auto-generated method stub
		return null;
	}

}
