package org.sella.learning.Collection;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkedList {

	public static void main(final String[] args) {
		
		/*final List<String> str = new java.util.LinkedList<String>();
		str.add("1");
		str.add("1");
		str.add("2");
		str.add("2");
		final Set<String> set = new HashSet<String>(str);
		System.out.println(set);*/
		
		final List<Employee> obj = new java.util.LinkedList<Employee>();
		final Employee emp = new Employee();
		emp.setDob(new Date());
		emp.setId(1234L);
		emp.setName("Karthik");
		obj.add(emp);
		final Employee emp1 = new Employee();
		emp1.setDob(new Date());
		emp1.setId(12345L);
		emp1.setName("Karthik1");
		obj.add(emp1);
		final Employee emp2 = new Employee();
		emp2.setDob(new Date());
		emp2.setId(12346L);
		emp2.setName("Karthik2");
		obj.add(emp2);
		final Employee emp3 = new Employee();
		emp3.setDob(new Date());
		emp3.setId(1234L);
		emp3.setName("Karthik");
		obj.add(emp3);		
		final Set<Employee> obj1 = new HashSet<Employee>();
		for(final Employee emps : obj ) {
			//System.out.println("Iteration" + emps.getName()+" --> " + (obj1.size()) +"--> "+obj1);
			obj1.add(emps);
		}
		System.out.println(obj1);
		
		/*final Set<Employee> obj1 = new LinkedHashSet<Employee>(obj);
		for(final Employee emps : obj1) {
			System.out.println(emps);
		}*/
	}
}