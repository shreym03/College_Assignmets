/*
  Write a Java program to input using Scanner
  @author Shrey Mathur
 */

import java.util.Scanner;

class Input {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Ener your favourite color: ");
		String fav_color = sc.next();
		System.out.print("Ener a small number: ");
		int num = sc.nextInt();
		System.out.println("Your favourite color is " + fav_color);
		System.out.println("The number is " + num);
		sc.close();
	}
}
