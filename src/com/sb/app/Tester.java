package com.sb.app;

import com.sb.domain.Student;

@FunctionalInterface
public interface Tester {
	public boolean test(Student s);
}
