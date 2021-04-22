/*
 Write a Java program to demonstrate in-built ArrayList Class
 @author Shrey Mathur
 */

import java.util.*;

class ArrayListTest1 {
	public static void main(String args[]) {
		ArrayList<String> al = new ArrayList<String>();
		al.add("Kelvin");
		al.add("Keerthna");
		al.add("Jennifer");
		Iterator<String> itr = al.iterator();
		while (itr.hasNext())
			System.out.println(itr.next());
	}
}
