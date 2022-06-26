package com.studentData.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class studentdb {
	public String fname;
	public String lname;
	public int rollno;
	public studentdb(String fname, String lname, int rollno) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.rollno = rollno;
	}
	public studentdb() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getRollno() {
		return rollno;
	}
	public void setRollno(int rollno) {
		this.rollno = rollno;
	}
	@Override
	//toString method is used to return a string representation of an object
	public String toString() {
		return "studentdb [fname=" + fname + ", lname=" + lname + ", rollno=" + rollno + "]";
	}
	
}
