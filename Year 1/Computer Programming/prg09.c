// Write a program to calculate the sum of cubes of numbers
#include <stdio.h>

void main() {
	int sum, n, i;
	sum = 0;
	printf("Enter the limit\n");
	scanf("%d", &n);
	for (i = 1;i <= n;i++) sum = sum + (i * i * i);
	printf(" The sum of the cubes of numbers till %d is %d\n", n, sum);
}

/* OUTPUT
	Enter the limit
	7
	The sum of the cubes of numbers till 7 is 784
*/