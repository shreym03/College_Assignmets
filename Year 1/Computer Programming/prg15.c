// tut 4 q1a
// Write a program to search for the first and last occurence of a given number in a given 2D matric
#include <stdio.h>

void main() {
	int a[50][50], count, key, m, n, i, j;
	printf("Enter the number of rows and columns of 2D-array\n");
	scanf("%d %d", &m, &n);
	printf("Enter %d values for the array\n", m * n);
	for (i = 0;i < m;i++)
		for (j = 0;j < n;j++)
			scanf("%d", &a[i][j]);
	printf("Enter the key to needed to be searched\n");
	scanf("%d", &key);
	count = 0;
	for (i = 0;i < m;i++)
		for (j = 0;j < n;j++)
			if (a[i][j] == key) {
				count++;
				printf("Occurance %d of %d is at row %d, column %d\n", count, key, i + 1, j + 1);
			}
	if (count > 0) {
		printf("\nThe total number of occurances of %d is %d\n", key, count);
		for (i = 0;i < m;i++)
			for (j = 0;j < n;j++)
				if (a[i][j] == key) {
					printf("The first occurance is at row %d, column %d\n", i + 1, j + 1);
					break;
				}
				
		for (i = m - 1;i >= 0;i--)
			for (j = n - 1;j >= 0;j--)
				if (a[i][j] == key) {
					printf("The last occurance is at row %d, column %d\n", i + 1, j + 1);
					break;
				}
	}
	else printf("Key is not found\n");
}
