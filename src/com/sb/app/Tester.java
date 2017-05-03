package com.sb.app;

import com.sb.domain.Student;

@FunctionalInterface
public interface Tester<T> {
	public boolean test(T value);
}
