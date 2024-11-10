package com.studentapp;

public class Main {

	public static void main(String[] args) {
		System.out.println("*** Student Managemnet System ***");
		System.out.println("************ Welcome ************");
		
		Student s1;
		s1 = new Student("Amala Talreja", 22, "S-1");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("Devops");
		s1.enrollCourse("C++");
		s1.enrollCourse("DSA");
		//System.out.println(s1);
		s1.printStudentInfo();
		
		Student s2 = new Student("Malu Trevejo", 26, "S-2");
		s2.enrollCourse("DSA");
		//System.out.println(s2);
		s2.printStudentInfo();
		
		Student s3 = new Student("Ritu Trevejo", 24, "S-3");
		s3.enrollCourse("devops");
		//System.out.println(s3);
		s3.printStudentInfo();
	}

}
