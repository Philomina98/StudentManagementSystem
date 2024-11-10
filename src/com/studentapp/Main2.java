package com.studentapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main2 {
	private static List<Student> studentList;
	public static void main(String[] args) {
		System.out.println("*** Student Managemnet System ***");
		System.out.println("************ Welcome ************");
		
		studentList = new ArrayList<Student>() ;
		
		Student s1;
		s1 = new Student("Amala Talreja", 22, "S-1");
		s1.enrollCourse("Java");
		s1.enrollCourse("DSA");
		s1.enrollCourse("Devops");
		s1.enrollCourse("C++");
		s1.enrollCourse("DSA");
		
		
		Student s2 = new Student("Malu Trevejo", 26, "S-2");
		s2.enrollCourse("DSA");
		
		Student s3 = new Student("Ritu Verma", 24, "S-3");
		s3.enrollCourse("devops");
		
		Student s4 = new Student("Ajay", 25, "S-4");
		s4.enrollCourse("devops");
		
		studentList.add(s1);
		studentList.add(s2);
		studentList.add(s3);
		studentList.add(s4);
		
		Student result = findStudentById("S-3");
		System.out.println("Result of search by studentID: "+result);
		
		sortByName();
		}
		
		private static void sortByName() {
			//creating custom comparator to compare student name
			Comparator<Student> studentNameComparator = new Comparator<Student>() {
				
				@Override
				public int compare(Student o1, Student o2) {
					// TODO Auto-generated method stub
					return o1.getName().compareTo(o2.getName());
				}
			};
			//using lambda expression:: can be written like below
			//Comparator<Student> studentNameComparator = (o1,o2) -> o1.getName().compareTo(o2.getName());
			
			//sorting student list with created custom comparator
		Collections.sort(studentList,studentNameComparator);
		System.out.println(studentList);
	}

		public static Student findStudentById(String studentId) {
			Student result = null;
			try {
				result = studentList.stream().filter(x -> x.getStudentId().equalsIgnoreCase(studentId))
						.findFirst()
						.orElseThrow(() -> new RuntimeException("No data found!!"));
			} catch (RuntimeException e) {
				System.err.println("Student with ID " + studentId + " not found");
			}
			return result;
		}

}
