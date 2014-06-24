package org.sella.learning.Inheritance;

class Testing extends Test1 implements TestInterface{
	
	@Override
	public void test() {		
		System.out.println("Child");
	}	
}

public class Inherit1{
	public static void main(final String[] args) {
		final Testing testing = new Testing();
		testing.test();
		 
	}
}