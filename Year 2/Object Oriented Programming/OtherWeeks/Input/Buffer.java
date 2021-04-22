/*
  Write a Java program to input using BufferedReader
  @author Shrey Mathur
 */

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

class Buffer {
	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Enter your name: ");
		String name = br.readLine();
		System.out.println("Your name is " + name);
		br.close();
	}
}
