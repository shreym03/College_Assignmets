// Write a C program to check the time taken to see if two arrays are similar or not 
#include <stdio.h>
#include <time.h>

void check(int a[], int b[], int n, int m) {
	int i, j, flag = 0;
	for (i = 0;i < n;i++)
		for (j = 0; i < m; j++) {
			if (a[i] == b[j]) {
				flag = 1;
				break;
			}
		}
	if (flag == 0) {
		printf("There are common elements present");
	}
	else
		printf("There are no common elements present");
}
void main() {
	clock_t start_t, end_t, total_t;
	int n, m;
	printf("Enter number of elements in both arrays\n");
	scanf("%d %d", &n, &m);
	int a[n];
	int b[m];
	printf("Enter the elements of array 1\n");
	for (int i = 0; i < n; ++i) {
		scanf("%d", &a[i]);
	}
	printf("Enter the elements of array 1\n");
	for (int i = 0; i < m; ++i) scanf("%d", &b[i]);
	
	start_t = clock();
	check(a, b, n, m);
	end_t = clock();

	printf("Start_t = %ld\n", start_t);
	printf("End time = %ld\n", end_t);
	total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
	printf("Total time taken by CPU: %f\n", total_t);
}
