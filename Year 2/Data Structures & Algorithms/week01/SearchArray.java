/*
  Write a Java program to caluculate the time taken to search for an element in
  an array
  
  @author Shrey Mathur
 */

import java.util.Scanner;

class SearchArray {

	private static boolean check(int a[], int n, int e) {
		boolean isFound = false;
		for (int i = 0; i < n; i++) {
			if (a[i] == e) {
				isFound = true;
				break;
			}
		}
		return isFound;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elemnts");
		int n = sc.nextInt();

		int ar[] = new int[n];
		System.out.println("Enter " + n + " values for the array");
		for (int i = 0; i < n; i++)
			ar[i] = sc.nextInt();

		System.out.println("Enter number to be searched");
		int e = sc.nextInt();

		long startTime = System.currentTimeMillis();
		boolean isFound = check(ar, n, e);
		if (isFound)
			System.out.println("Element found");
		else
			System.out.println("Element is not found");
		long endTime = System.currentTimeMillis();
		System.out.println("The start time is " + startTime);
		System.out.println("The end time is " + endTime);
		long totalTime = endTime - startTime;
		System.out.println("The total time taken is " + totalTime);
		sc.close();
	}
}

// OUTPUT
// Enter number of elemnts
// 3
// Enter 3 values for the array
// 1 2 3
// Enter
// number to be searched
// 2
// Element found
// The start time is 1617256038871
// The end time is 1617256038871
// The total time taken is 0
