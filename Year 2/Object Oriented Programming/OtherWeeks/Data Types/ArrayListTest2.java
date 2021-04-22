/*
 Write a Java program to demonstrate in-built ArrayList Class
 Part 2
 @author Shrey Mathur
 */

import java.util.*;

class ArrayListTest2 {
	public static void main(String args[]) {
		ArrayList<String> a1 = new ArrayList<String>();
		ArrayList<String> a2 = new ArrayList<String>();
		a1.add("Kelvin");
		a1.add("Keerthna");
		a2.add("Kelvin");
		a2.add("Anubhav");
		a1.removeAll(a2);
		for (String obj : a1)
			System.out.println(obj);
		System.out.println();
		a1.addAll(a2);
		for (String obj : a1)
			System.out.println(obj);
	}
}
