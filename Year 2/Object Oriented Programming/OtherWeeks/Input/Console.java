/*
  Write a Java program to input using System.console
  @author Shrey Mathur
 */

class Console {
	public static void main(String[] args) {
		System.out.print("Enter your name: ");
		String name = System.console().readLine();
		System.out.println("Your name is " + name);
	}
}
