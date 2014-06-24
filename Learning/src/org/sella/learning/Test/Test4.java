package org.sella.learning.Test;

public class Test4 {
	public static void main(final String[] args) {
		final String test = "foo  bar";
		final char[] chars = test.toCharArray();
		System.out.println("length " + chars.length);
		int i = 0;
		for (final char c : chars) {
			System.out.println(c + " " + i);
			i++;
		}
	}
}
