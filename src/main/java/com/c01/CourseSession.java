package com.c01;

import java.util.*;

public class CourseSession {

	private String department;
	private String number;
	private List<Student> allStudents;

	CourseSession(String department, String number) {
		this.department = department;
		this.number = number;
	}

	public String getDepartment() {
		return department;
	}

	public String getNumber() {
		return number;
	}

	public int getNumberOfStudent() {
		return allStudents.size();
	}

	public void enroll (Student student){
		if (null == allStudents) {
			allStudents = new ArrayList<Student>();
		}
		allStudents.add(student);
	}

	public List<Student> getAllStudents(){
		return allStudents;
	}
}
