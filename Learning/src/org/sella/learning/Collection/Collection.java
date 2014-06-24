package org.sella.learning.Collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;
import java.util.Vector;

public class Collection {
	
	public static void main(final String[] args) {
		final List<String> list = new ArrayList<String>();
		list.add("1");
		list.add("5");
		list.add("2");
		System.out.println("List 1--> "+list);		
		for(final String temp: list) {
			System.out.print(" "+temp);
		}
		System.out.println();
		Collections.sort(list);
		System.out.println("List 2--> "+list);	
		System.out.println();
		System.out.println();
		
		final List<String> list1 = new java.util.LinkedList<String>();
		list1.add("1");
		list1.add("5");
		list1.add("2");
		System.out.println("L.List 1--> "+list1);		
		for(final String temp: list1) {
			System.out.print(" "+temp);
		}
		System.out.println();
		Collections.sort(list1);
		System.out.println("L.List 2--> "+list1);	
		System.out.println();
		System.out.println();
		
		final Set<String> set = new HashSet<String>();
		set.add("1");
		set.add("5");
		set.add("2");
		System.out.println("HashSet 1--> "+set);	
		for(final String temp: set) {
			System.out.print(" "+temp);
		}
		System.out.println();
		System.out.println();
		
		final Set<String> set1 = new TreeSet<String>();
		set1.add("1");
		set1.add("5");
		set1.add("3");
		System.out.println("Tree Set 1--> "+set1);
		set1.add("2");
		System.out.println("Tree Set 2--> "+set1);
		for(final String temp: set1) {
			System.out.print(" "+temp);
		}
		System.out.println();
		System.out.println();
		
		final Vector<String> vector = new Vector<String>();
		vector.add("1");
		vector.add("5");
		vector.add("3");
		System.out.println("Vector Set 1--> "+vector);
		vector.add("2");
		System.out.println("Vector Set 2--> "+vector);
		for(final String temp: vector) {
			System.out.print(" "+temp);
		}
		System.out.println();
		System.out.println();
		
		final Stack<String> stack = new Stack<String>();
		stack.add("1");
		stack.add("5");
		stack.add("3");
		System.out.println("Stack Set 1--> "+stack);
		stack.add("2");
		System.out.println("Stack Set 2--> "+stack);
		for(final String temp: stack) {
			System.out.print(" "+temp);
		}
		System.out.println();
		System.out.println();
		
	}
}