package org.sella.learning.Static;

public class StaticCheck {
	public static void main(final String[] args) {
		final Check check = null;
		check.check();
	}
}

class Check {
	public static void check() {
		System.out.println("Called");
	}
}