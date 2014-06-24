package org.sella.learning.Exception;

public class TryCatch1 {
	public static void main(final String[] args) {
		final TryCatch1 obj = new TryCatch1();
		obj.test();
	}

	private void test() {
		try {
			sample();
		} catch (final Exception e) {
			e.printStackTrace();
		}
	}

	private void sample() {
		try {
			throwError();
		} finally {

		}
	}

	private void throwError() {
		final int i = 10 / 0;
	}
}
