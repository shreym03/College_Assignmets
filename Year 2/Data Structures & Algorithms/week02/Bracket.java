/*
  Write a Java program to check if a equation is alanced by making sure all
  brackets are closed
  
  @author Shrey Mathur
 */

import java.util.Scanner;
import java.util.Stack;

class Bracket {
	static boolean check(Stack<Character> s, String a) {
		// bracket counters
		int b1 = 0, b2 = 0, b3 = 0;
		char c, c2;
		for (int i = 0; i < a.length(); i++) {
			c = a.charAt(i);

			switch (c) {
			case '(':
				s.push(c);
				b1++;
				break;
			case '{':
				s.push(c);
				b2++;
				break;
			case '[':
				s.push(c);
				b3++;
				break;
			// First check if a bracket exists in the counter
			// then check if opening bracket matches closing bracket
			case ')':
				if (b1 == 0)
					return false;
				else {
					c2 = s.pop();
					if (c2 == '(')
						b1--;
					else
						return false;
				}
				break;
			case '}':
				if (b2 == 0)
					return false;
				else {
					c2 = s.pop();
					if (c2 == '{')
						b2--;
					else
						return false;
				}
				break;
			case ']':
				if (b3 == 0)
					return false;
				else {
					c2 = s.pop();
					if (c2 == '[')
						b3--;
					else
						return false;
				}
				break;
			}
		}
		if (s.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> st = new Stack<>();
		System.out.println("Enter the expression to be checked");
		String a = sc.next();
		if (check(st, a))
			System.out.println("The expression is balanced");
		else
			System.out.println("The expression is not balanced");
		sc.close();
	}
}
