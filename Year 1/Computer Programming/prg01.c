// Write a C program to accept 2 integer, 2 float numbers from user ans perform the following -
// 	1) Find the sum of the 2 integer numbers
// 	2) Difference between the float numbers
// Print the same
#include <stdio.h>

void main() {
	int a, b, sum;
	float c, d, diff;
	printf("Enter two integers: ");
	scanf("%d%d", &a, &b);
	printf("Enter 2 float numbers: ");
	scanf("%f%f", &c, &d);
	sum = a + b;
	diff = c - d;
	printf("The Sum is %d\nThe Difference is %f\n", sum, diff);
}

/* OUTPUT
	Enter two integers: 2 3
	Enter 2 float numbers: 5.7 3.5
	The Sum is 5
	The Difference is 2.200000
 */