package com.sb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.BiConsumer;

import com.sb.domain.Student;

public class StudentService {

	private static Map<Integer, Student> students = new ConcurrentHashMap<>();

	// private static int nextId;
	private static AtomicInteger nextId = new AtomicInteger(0);

	static {
		int id = nextId.incrementAndGet();
		students.put(id, new Student(id, "Sammy", Student.Status.FULL_TIME));
		id = nextId.incrementAndGet();
		students.put(id, new Student(id, "Manoj", Student.Status.FULL_TIME));
		id = nextId.incrementAndGet();
		students.put(id, new Student(id, "Ana", Student.Status.HIBERNATING));
	}

	public Student getStudent(int id) {
		return students.get(id);
	}

	public Student addStudent(Student s) {
		int id = nextId.incrementAndGet();

		s.setId(id);
		students.put(s.getId(), s);

		return s;
	}

	public List<Student> getStudentsStartingWith(String c) {
		List<Student> result = new ArrayList<>();
		students.forEach(new BiConsumer<Integer, Student>() {
			public void accept(Integer key, Student student) {
				if (student.getName().startsWith(c)) {
					result.add(student);
				}
			}
		});

		students.forEach((key, student) -> {
			if (student.getName().startsWith(c)) {
				result.add(student);
			}
		});

		return result;
	}

	public List<Student> getAllStudents() {
		List<Student> result = new ArrayList<>();

		students.forEach((key, value) -> {
			result.add(value);
		});

		return result;

	}

	class XYZ {

	}

	class MyConsumer implements BiConsumer<Integer, Student> {
		private List<Student> myList;

		public MyConsumer(List<Student> l) {
			myList = l;
		}

		@Override
		public void accept(Integer key, Student value) {
			System.out.println(key + "=" + value);
			myList.add(value);
		}

	}
}
