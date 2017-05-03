package com.sb.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import com.sb.domain.Student;

public class Sorter {
	
	public static void main(String[] args) {
		new Sorter();
	}
	
	public Sorter() {
		List<Student> students = Arrays.asList( 
				new Student(10, "Mary", Student.Status.HIBERNATING),
				new Student(3, "Zoe", Student.Status.FULL_TIME),
				new Student(7, "Madhu", Student.Status.FULL_TIME),
				new Student(2, "Roberta", Student.Status.FULL_TIME),
				new Student(4, "Sameer", Student.Status.FULL_TIME));
		
		List<Student> result = filter(students, (s) -> s.getId() > 2);
		List<String> names = new ArrayList<>();
		for(Student s : result) {
			names.add(s.getName());
		}

	
		List<List<String>> n2 = students.stream()
				.parallel()
				.filter((student) -> student.getId() > 2)
				.map((st) -> Arrays.asList(st.getName()))
				.collect(Collectors.toList());
		
		Map<Integer, List<Student>> m = students.stream()
				.filter(s -> s.getId() > 2)
				.collect(Collectors.groupingBy(s -> s.getId()));
		

		
		System.out.println(result);
		

		

	}

	public <T> List<T> filter(List<T> input, Predicate<T> tester) {
		List<T> result = new ArrayList<>();
		input.forEach(new Consumer<T>() {
			public void accept(T value) {
				if(tester.test(value)) {
					result.add(value);
				}
			}
		});
		

		return result;
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
