/*
  a Java program to check the time taken by an array checking funtionWrite
  
  @author Shrey Mathur
 */

import java.util.Scanner;

class Unique {

	public static boolean check(int a[]) {
		boolean isTrue = true;
		int len = a.length;
		for (int i = 0; i < len; i++)
			for (int j = i + 1; j < len; j++) {
				if (a[i] != a[j]) {
					isTrue = false;
					break;
				}
			}
		return isTrue;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter number of elements");
		int n = sc.nextInt();
		int arr[] = new int[n];

		System.out.println("Enter " + n + " elements");
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		long startTime = System.currentTimeMillis();
		boolean result = check(arr);
		if (result)
			System.out.println("Elements are unique");
		else
			System.out.println("Elements are not unique");
		long endTime = System.currentTimeMillis();
		System.out.println("The start time is " + startTime);
		System.out.println("The end time is " + endTime);
		long totalTime = endTime - startTime;
		System.out.println("The total time taken is " + totalTime);
		sc.close();
	}
}

// OUTPUT
// Enter number of elements
// 10
// Enter 10 elements
// 1 2 3 4 5 6 7 8 9 9
// Elements are not unique
// The start time is 1617000140018
// The end time is 1617000140018
// The total time taken is 0
