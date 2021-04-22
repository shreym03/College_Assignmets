/*
  Write a Java program to find a a value from an Ackermann table based on
  Ackermann's algorithm
  
  @author Shrey Mathur
 */

import java.util.*;

class Ackerman {
	public int A(int m, int n) {
		if (m < 0 || n < 0)
			throw new IllegalArgumentException("Postive arguments only");

		if (m == 0)
			return n + 1;
		else if (n == 0)
			return A(m - 1, 1);
		else
			return A(m - 1, A(m, n - 1));
	}
}

class AckermanTest {
	public static void main(String[] args) {
		int result;
		Ackerman a = new Ackerman();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the two numbers");
		int row = sc.nextInt();
		int col = sc.nextInt();
		result = a.A(row, col);
		System.out.println("The result is " + result);
		sc.close();
	}
}
