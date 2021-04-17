// Write a C program to print the total time taken to check the uniqueness of an array

#include <stdio.h>
#include <stdlib.h>
#include <time.h>

void check(int n, int a[]) {
	int i, j, flag = 0;
	for (i = 0;i < n;i++)
		for (j = i + 1; j < n; j++) {
			if (a[i] == a[j]) {
				flag = 1;
				break;
			}
		}

	if (flag == 0) 	printf("All elements are unique\n");
	else printf("All elements are not unique\n");
}

void main() {
	clock_t start_t, end_t, total_t;
	int n;
	printf("Enter the value of n\n");
	scanf("%d", &n);
	int arr[n];
	printf("Enter the elements of array\n");
	for (int i = 0; i < n; i++) {
		scanf("%d", &arr[i]);
	}
	start_t = clock();
	check(n, arr);
	end_t = clock();

	printf("Start_t = %ld\n", start_t);
	printf("End time = %ld\n", end_t);
	total_t = (end_t - start_t) / CLOCKS_PER_SEC;
	printf("Total time taken by CPU: %ld\n", total_t);
}
