// tut 4 q2
// Write a program to sort a 2D array in each column

#include <stdio.h>

void main() {
	int a[50][50], m, n, i, j, k;
	printf("Enter the number of rows and columns of 2D-array\n");
	scanf("%d %d", &m, &n);
	printf("Enter %d values into the array\n", m * n);
	for (i = 0;i < m;i++)
		for (j = 0;j < n;j++) scanf("%d", &a[i][j]);
	for (k = 0;k < n;k++) {
		for (i = 1;i < m;i++) {
			j = i;
			while (j > 0 && a[j][k] < a[j - 1][k]) {
				a[j][k] = a[j][k] + a[j - 1][k];
				a[j - 1][k] = a[j][k] - a[j - 1][k];
				a[j][k] = a[j][k] - a[j - 1][k];
				j--;
			}
		}
	}
	printf("The column sorted array is\n");
	for (i = 0;i < m;i++) {
		for (j = 0;j < n;j++) printf("%d\t", a[i][j]);
		printf("\n");
	}
}
