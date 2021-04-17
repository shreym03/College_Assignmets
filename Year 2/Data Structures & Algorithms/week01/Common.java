/*
  Write a Java program to check the time taken to see if two arrays are similar
  or not
  
  @author Shrey Mathur
 */

import java.util.Scanner;

class Common {
    public static boolean check(int a[], int b[]) {
        boolean isTrue = false;
        int na = a.length;
        int nb = b.length;

        for (int i = 0; i < na; i++)
            for (int j = 0; j < nb; j++) {
                if (a[i] == b[j]) {
                    isTrue = true;
                    break;
                }
            }
        return isTrue;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements for both arrays");
        int n = sc.nextInt();
        int m = sc.nextInt();
        int a[] = new int[n];
        int b[] = new int[m];

        System.out.println("Enter " + n + " elements for array 1");
        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        System.out.println("Enter " + m + "elements for array 2");
        for (int i = 0; i < m; i++)
            b[i] = sc.nextInt();

        long startTime = System.currentTimeMillis();
        boolean result = check(a, b);
        if (result)
            System.out.println("There are common elements in the arrays");
        else
            System.out.println("There are no common elements");
        long endTime = System.currentTimeMillis();
        System.out.println("The start time is " + startTime);
        System.out.println("The end time is " + endTime);
        long totalTime = endTime - startTime;
        System.out.println("The total time taken is " + totalTime);
        sc.close();
    }
}
