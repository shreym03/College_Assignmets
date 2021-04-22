/* 
  Write a Java Programme to read a marks in 3 subjects and to find his average and display the appropriate message.
  avg>=75:Distinction.
  avg>=60:First Class.
  avg>=50:Second Class.
  avg>=40:Third Class.
  
  @author Shrey Mathur
  @since 3/9/17
 */

import java.io.*;

class MarksCheck {
	public static void main(String[] args) throws IOException {

		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		System.out.print("Enter Marks 1: ");
		float m1 = Float.parseFloat(br.readLine());
		System.out.print("Enter Marks 2: ");
		float m2 = Float.parseFloat(br.readLine());
		System.out.print("Enter Marks 3: ");
		float m3 = Float.parseFloat(br.readLine());
		float avg = (m1 + m2 + m3) / 3;
		System.out.println("The average is " + avg);
		if (avg >= 75)
			System.out.println("Rank: Distinction");
		else if (avg > 59)
			System.out.println("Rank: First Class");
		else if (avg > 49)
			System.out.println("Rank: Second Class");
		else if (avg > 39)
			System.out.println("Rank: Third Class");
		else
			System.out.println("Rank: None");
	}
}
