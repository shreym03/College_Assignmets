// Write a C program to print the fibonacci series
#include <stdio.h>

void main() {
	int l2 = 0, l1 = 1, next, n, i;	// l2 is second last no.,l1 is last no.
	printf("Enter the upper limit of the fibonacci series\n");
	scanf("%d", &n);
	printf("%d %d ", l2, l1);
	next = l2 + l1;
	while (next <= n) {
		printf("%d ", next);
		l2 = l1;
		l1 = next;
		next = l2 + l1;
	}
	printf("\n");
}

/* OUTPUT
	Enter the upper limit of the fibonacci series
	9    
	0 1 1 2 3 5 8 
*/