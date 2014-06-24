package org.sella.learning.Exception;

public class StackOverFlowCheck {

	public static void main(final String[] args) {
		final StackOverFlowCheck check = new StackOverFlowCheck();
		check.test();
	}

	private void test() {
		while (true) {
			test();
		}
	}
}