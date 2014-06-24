package org.sella.learning.Exception;

import java.util.ArrayList;
import java.util.List;

import org.sella.learning.Collection.Employee;

public class OutofMemoryException {
	public static void main(final String[] args) {
		final List<Employee> list = new ArrayList<Employee>();
		while(true) {			
			final Employee employee = new Employee();
			list.add(employee); 			 
		}
	}
}
