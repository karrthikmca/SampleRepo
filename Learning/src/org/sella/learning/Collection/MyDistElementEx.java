package org.sella.learning.Collection;

import java.util.HashSet;

public class MyDistElementEx {

	public static void main(final String a[]) {

		final HashSet<Price> lhm = new HashSet<Price>();
		lhm.add(new Price("Banana", 20));
		lhm.add(new Price("Apple", 40));
		lhm.add(new Price("Orange", 30));
		for (final Price pr : lhm) {
			System.out.println(pr);
		}
		// final Price duplicate =
		System.out.println("inserting duplicate object...");
		System.out.println(lhm.add(new Price("Banana", 20)));
		System.out.println("After insertion:");
		for (final Price pr : lhm) {
			System.out.println(pr);
		}
	}
}