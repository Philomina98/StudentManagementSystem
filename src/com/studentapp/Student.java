package com.studentapp;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {

	// instance variables
	private String name;
	private int age;
	private String studentId;
	private List<String> courses;

	// constructor to initialize instance variables
	public Student(String name, int age, String studentId) {
		super();
		if (validateAge(age) && validateName(name) && validateStudentID(studentId)) {
			this.name = name;
			this.age = age;
			this.studentId = studentId;
			courses = new ArrayList<String>(); // Initialization of courses instance variable
		}
	}

	public void enrollCourse(String course) {
		if (validateCourseName(course)) {
			if (!courses.contains(course)) {
				courses.add(course);
				System.out.println("Student is enrolled to the " + course + " successfully");
			} else {
				System.err.println("Student is already enrolled to the course " + course);
			}
		}
	}

	public void printStudentInfo() {
		System.out.println("------Student Information------");
		System.out.println("Student Name: " + name);
		System.out.println("Student Age: " + age);
		System.out.println("Student Id: " + studentId);
		System.out.println("Enrolled for: " + courses);
		System.out.println("-------------------------------");
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", studentId=" + studentId + ", courses=" + courses + "]";
	}

	// Validation methods for age
	public boolean validateAge(int age) {
		if (age >= 19 && age <= 35) {
			return true;
		} else {
			System.err.println("Invalid Age!!! Student age needs to be between 19 and 35");
			return false;
		}
	}

	public boolean validateName(String name) {
		// amala AMALA Amala amALA Talreja
		String nameRegex = "^[a-zA-Z\\s]+$";
		Pattern namePattern = Pattern.compile(nameRegex);
		Matcher nameMatcher = namePattern.matcher(name);
		if (nameMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid Name!!! Please enter alphabets only");
			return false;
		}

	}

	public boolean validateStudentID(String studentId) {
		// S-123, ...
		String studentIdRegex = "S-[0-9]+$"; // can also be S-\\d+$
		Pattern studentIdPattern = Pattern.compile(studentIdRegex);
		Matcher studentIdMatcher = studentIdPattern.matcher(studentId);
		if (studentIdMatcher.matches()) {
			return true;
		} else {
			System.err.println("Invalid StudentId!!! Use the format Eg.. S-1234");
			return false;
		}
	}
	public boolean validateCourseName(String course) {
		if (course.equalsIgnoreCase("Java") || course.equalsIgnoreCase("DSA") || course.equalsIgnoreCase("Devops") ) {
			return true;	
		} else {
			System.err.println("Invalid Course Name!!! "+course+" Please select courses from the list [Java,DSA,Devops]");
			return false;
		}
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getStudentId() {
		return studentId;
	}

	public List<String> getCourses() {
		return courses;
	}
	
}
