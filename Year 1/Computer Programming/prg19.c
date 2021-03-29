// Write a program to calculate sum of diagonals, sum of upper triangle, 
// highest value in each row and transpose of square matrix
#include <stdio.h>

void main() {
	int a[50][50], i, j, n;
	printf("Enter the number of rows in square matrix\n");
	scanf("%d", &n);
	printf("Enter %d values for the square matrix (In order)\n", n * n);
	for (i = 0;i < n;i++)
		for (j = 0;j < n;j++)
			scanf("%d", &a[i][j]);
	int sumdg = 0, sumupr = 0, max[n];
	for (i = 0;i < n;i++) {
		max[i] = a[i][0];
		for (j = 0;j < n;j++) {
			if (i == j)
				sumdg += a[i][j];
			if ((i + j) < n)
				sumupr += a[i][j];
			if (a[i][j] > max[i])
				max[i] = a[i][j];
		}
	}
	printf("The sum of Diagonals is %d \nThe sum of upper triangle is %d \n", sumdg, sumupr);
	for (i = 0;i < n;i++)
		printf("The highest value in row %d is %d\n", i + 1, max[i]);
	printf("The transpose of the given matrix is\n");
	for (i = 0;i < n;i++) {
		for (j = 0;j < n;j++) printf("%d\t", a[j][i]);
		printf("\n");
	}
}

/* OUTPUT
	Enter the number of rows in square matrix
	2
	Enter 4 values for the square matrix (In order)
	1 2 6 4
	The sum of Diagonals is 5
	The sum of upper triangle is 9
	The highest value in row 1 is 2
	The highest value in row 2 is 6
	The transpose of the given matrix is
	1       6
	2       4
*/