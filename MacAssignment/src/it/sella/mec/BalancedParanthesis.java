package it.sella.mec;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public final class BalancedParanthesis {


	public static String isBalanced(final String input1) {
		final Map<Character, Character> brackets = new HashMap<Character, Character>();
		brackets.put('[', ']');
		brackets.put('{', '}');
		brackets.put('(', ')');
		if (input1.length() == 0) {
			return "Incorrect";
		}

		if ((input1.length() % 2) != 0) {
			return "Incorrect";
		}

		final Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < input1.length(); i++) {
			if (brackets.containsKey(input1.charAt(i))) {
				stack.push(input1.charAt(i));
			} else if (stack.empty() || (input1.charAt(i) != brackets.get(stack.pop()))) {
				return "Incorrect";
			}
		}
		return "Correct";
	}

	public static void main(final String[] args) {
		System.out.println(isBalanced("()()()(()([]))"));
		System.out.println(isBalanced("([}])"));
		System.out.println(isBalanced("([])"));
		System.out.println(isBalanced("({}[((({{}})[{()}]))])"));
	}
}