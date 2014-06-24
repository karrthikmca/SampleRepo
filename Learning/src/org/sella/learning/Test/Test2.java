package org.sella.learning.Test;

import java.util.Arrays;

public class Test2 {
	public static void main(final String[] args) {
		final int[] input1 = { 12, 2, 3, 4, 5, 6 };
		final int[] input2 = { 6, 5, 4, 3, 2, 2 };
		System.out.println(test(input1, input2));
	}

	public static String test(final int[] input1, final int[] input2) {
		if (!(input1 == null || input2 == null)) {
			Arrays.sort(input1);
			Arrays.sort(input2);			
			return (Arrays.toString(input1).equals(Arrays.toString(input2))) ? "Lucky" : "Unlucky";
		}
		return "Unlucky";
	}
}
