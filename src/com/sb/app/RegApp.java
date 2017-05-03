package com.sb.app;

import java.util.List;

import com.sb.domain.Student;
import com.sb.service.StudentService;

public class RegApp {

	public static void main(String [] args) {
		StudentService ss = new StudentService();
		List<Student> students = ss.getAllStudents();
		System.out.println(students);
		
		//students = ss.getStudentsStartingWith(new TestForFirstNames("A"));
		System.out.println("A students: " + students);

		Tester<Student> fullTimeStudents = new Tester<Student>() {
			public boolean test(Student student) {
				return student.getStatus() == Student.Status.FULL_TIME;
			}
		};
		students = ss.getStudentsFilteredBy(fullTimeStudents);

		students = ss.getStudentsFilteredBy((student) -> 
				student.getStatus() == Student.Status.FULL_TIME
		);
		
		students = ss.getStudentsFilteredBy(student -> student.getId() > 10);

		students = ss.getStudentsFilteredBy(student -> student.getId() > 10);
		
		
		
		System.out.println("fullTimeStudents students: " + students);
	}
	


	public static void req1() {
		StudentService ss = new StudentService();

		Student s2 = new Student("Rachna", Student.Status.PART_TIME);
		ss.addStudent(s2);

	}

	public static void req2() {
		StudentService ss = new StudentService();

		//List<Student> students = ss.getAllStudents();

		ss.getAllStudents();

		/*
		for (Student s : students) {
			System.out.println(s);
		}
		*/
	}


}
