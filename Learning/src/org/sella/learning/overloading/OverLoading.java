package org.sella.learning.overloading;

public class OverLoading {
	public static void main(final String[] args) {
		final OverLoading loading = new OverLoading();
		loading.start();
	}

	private void start() {
		//method1(null); // ambiguous Error at compile time
		method2(null); // ambiguous Error at compile time
	}

	private void method1(final StringBuffer object) {
		System.out.println("StringBuffer");
	}

	private void method1(final StringBuilder object) {
		System.out.println("StringBuilder");
	}

	private void method2(final ClassA object) {
		System.out.println("Parent");
	}

	private void method2(final ClassB object) {
		System.out.println("Child");
		object.test();
	}
}