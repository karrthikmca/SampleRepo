package org.sella.learning.Test;

public class Test3 {
	public static void main(final String[] args) {
		final Test1 test1 = new Test1();
		final Test1 test2 = (Test1) test1.clone();
		System.out.println(test1);
		System.out.println(test2);
	}

}
