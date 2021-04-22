/*
  WAJP to read number N and to display if the number is odd,even or a multilple of 5 or 10
  @since 3/9/17
  @author Shrey
 */

import java.io.*;

class OddEven {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Enter your number: ");
		int n = Integer.parseInt(br.readLine());
		if (n % 2 == 0)
			System.out.print("The number is even");
		else
			System.out.print("The number is odd");

		if (n % 5 == 0)
			System.out.println(" and a multiple of 5");
		else
			System.out.println();
		br.close();
	}
}
