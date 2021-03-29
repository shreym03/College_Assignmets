// tut-3 Q5
// Write a program to find the sum of  two 2D arrays

#include <stdio.h>

void main() {
	int a[100][100], b[100][100], i, j, m, n;
	printf("Enter the number of rows and columns\n");
	scanf("%d %d", &m, &n);
	printf("Enter %d values for matrix A (In order)\n", m * n);
	for (i = 0;i < m;i++)
		for (j = 0;j < n;j++) scanf("%d", &a[i][j]);
	printf("Enter %d values for matrix B (In order)\n", m * n);
	for (i = 0;i < m;i++)
		for (j = 0;j < n;j++) scanf("%d", &b[i][j]);
	printf("The sum of the two matrices is\n");
	for (i = 0;i < m;i++) {
		for (j = 0;j < n;j++) printf("%d\t", a[i][j] + b[i][j]);
		print("\n");
	}
}
