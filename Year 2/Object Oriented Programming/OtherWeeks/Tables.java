/*
  Write a Java programme to read a number N from the user 
	and to display the tables of the number till 12
  
  @since 03/09/2017
  @author Shrey
 */

import java.io.*;

class Tables {
	public static void main(String[] args) throws IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Enter your number: ");
		int n = Integer.parseInt(br.readLine());
		for (int i = 1; i <= 12; i++)
			System.out.println(n + " * " + i + " = " + n * i);
	}
}
