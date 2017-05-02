package com.sb.app;

import java.util.List;
import java.util.function.Consumer;

import com.sb.domain.Student;
import com.sb.service.StudentService;

public class RegApp {

	public static void main(String [] args) {
		StudentService ss = new StudentService();
		List<Student> students = ss.getAllStudents();
		System.out.println(students);
		
		students.forEach(student -> System.out.println(student));

		students.forEach(new Consumer<Student>() {
			public void accept(Student s) {
				System.out.println(s);
			}
		});
	}

	public static void main2(String[] args) {
		Thread th = new Thread(() -> {
			while (true) {
				RegApp.req1();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
				}
			}
		});

		th.start();

		Thread th2 = new Thread(() -> {
			while (true) {
				RegApp.req2();
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {
				}
			}
		});
		
		th2.start();

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
