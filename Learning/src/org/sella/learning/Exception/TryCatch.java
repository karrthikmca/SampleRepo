package org.sella.learning.Exception;

public class TryCatch {
	public static void main(final String[] args) {
		final TryCatch obj = new TryCatch();
		obj.test();
	}

	private void test() {
		try {
			throwError();
		} finally {
			System.out.println("Finally");
		}
	}


	private void throwError() throws RuntimeException{
		final int i = 10 / 0;
	}
}
