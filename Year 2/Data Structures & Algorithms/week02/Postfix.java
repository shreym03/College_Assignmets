
/*
  Write a Java ` program to evaluate a postfix expression and give the result
  
  @author Shrey Mathur
 */
import java.util.Scanner;
import java.util.Stack;

class Postfix {
	static int evaluate(Stack<Integer> s, String pf) {
		char c;
		int a, b, r;
		for (int i = 0; i < pf.length(); i++) {
			c = pf.charAt(i);
			if (Character.isDigit(c))
				s.push(c - '0'); // Subtracting the ASCII value of '0' from the digit
			else if (c == '+' || c == '-' || c == '/' || c == '*') {
				a = s.pop();
				b = s.pop();

				switch (c) {
				case '+':
					r = a + b;
					s.push(r);
					break;
				case '-':
					r = a - b;
					s.push(r);
					break;
				case '/':
					r = a / b;
					s.push(r);
					break;
				case '*':
					r = a * b;
					s.push(r);
					break;
				}
			}
		}
		int result = s.pop();
		return result;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Integer> st = new Stack<>();
		System.out.println("Enter the postfix condition");
		String exp = sc.next();
		System.out.println("The result of the expression is " + evaluate(st, exp));
		sc.close();
	}
}
