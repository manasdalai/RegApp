package com.sb.app;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.sb.domain.Student;

public class Sorter {
	
	public static void main(String[] args) {
		new Sorter();
	}
	
	public Sorter() {
		List<Student> students = Arrays.asList( 
				new Student(10, "Mary", Student.Status.HIBERNATING),
				new Student(3, "Zoe", Student.Status.FULL_TIME),
				new Student(4, "Sameer", Student.Status.FULL_TIME));
		
		List<String> ls = Arrays.asList("one", "two", "three");

		Collections.sort(students);
		
		System.out.println(students);
		
		Collections.sort(students, new NameComparator());

		Collections.sort(students, (o1, o2) -> 
			o1.getName().compareTo(o2.getName())
		);

		Collections.sort(students, (o1, o2) -> 
			o1.getName().compareTo(o2.getName())
		);
		
		
		students.forEach(s -> foo(s));

		students.forEach(this::foo);

	}
	
	public void foo(Student s) {
		System.out.println(s);
	}

	static class NameComparator implements Comparator<Student>
	{

		@Override
		public int compare(Student o1, Student o2) {
			return o1.getName().compareTo(o2.getName());
		}
		
	}
	

}
