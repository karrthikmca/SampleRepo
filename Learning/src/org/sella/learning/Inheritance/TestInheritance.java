package org.sella.learning.Inheritance;

public class TestInheritance {
	public static void main(final String[] args) {
		final Parent c= new Child();
		c.sample();
		System.out.println(c.count);
		
		final Child child = new Child();		
		child.sample();
		System.out.println(child.count);
		
		final Parent parent= new Parent();
		parent.sample();
		System.out.println(parent.count);
	}
}
