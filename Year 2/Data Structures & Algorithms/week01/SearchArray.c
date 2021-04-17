// Write a C program to check
#include <stdio.h>
#include <time.h>

void check(int a[], int n, int e) {
	int i, flag = 0;
	for (i = 0;i < n;i++) {
		if (a[i] == e) {
			flag = 1;
			break;
		}
	}
	if (flag == 0) printf("Element was not found\n");
	else printf("element was found\n");
}
void main() {
	clock_t start_t, end_t, total_t;
	int n, e;
	printf("Enter the vale of n:\n");
	scanf("%d", &n);
	int a[n];
	printf("Enter %d elements for the array:\n", n);
	for (int i = 0; i < n; ++i) scanf("%d", &a[i]);

	printf("\nEnter element to be searched\n");
	scanf("%d", &e);
	start_t = clock();
	check(a, n, e);
	end_t = clock();
	printf("Start_t = %ld\n", start_t);
	printf("End time = %ld\n", end_t);
	total_t = (double)(end_t - start_t) / CLOCKS_PER_SEC;
	printf("Total time taken by CPU: %f\n", total_t);
}
