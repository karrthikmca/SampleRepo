package org.sella.learning.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test1 implements Cloneable {

	public static void main(final String[] args) {
		final int[] input1 = { 5, 8, 9, 4, 3, 6, 8, 7, 8 };
		final int[] input2 = { 1, 1, 1, 1, 1, 1 };
		System.out.println(test(input1, input2));
	}

	private static String test(final int[] input1, final int[] input2) {
		String value = "Unlucky";
		if (!(input1 == null || input2 == null)) {
			final List<Integer> list1 = new ArrayList<Integer>();
			for (final int temp : input1) {
				list1.add(temp);
			}
			final List<Integer> list2 = new ArrayList<Integer>();
			for (final int temp : input2) {
				list2.add(temp);
			}
			Collections.sort(list1);
			Collections.sort(list2);
			System.out.println(Collections.min(list1));
			if (list1.equals(list2)) {
				value = "Lucky";
			}
		}
		return value;
	}
	
	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (final CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	@Override
	public int hashCode() {
		return 10258;
	}

}
