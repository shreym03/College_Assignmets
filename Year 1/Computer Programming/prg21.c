// tut 4 q3
// Write a program to find a key in a 2D array
#include <stdio.h>

void main() {
	int  i, j, k, key, flag = 0, beg, end, mid, resrw, rescl;
	int a[2][5] = { {11,12,13,14,15}, {16,17,18,19,20} };
	printf("Enter the key that is to be searched\n");
	scanf("%d", &key);
	for (i = 0;i < 2 && flag == 0;i++) {
		// Checking row first 
		if (key >= a[i][0] && key <= a[i][4]) {
			// and then checking inside column using binary search
			beg = 0;
			end = 4;
			while (beg <= end) {
				mid = (beg + end) / 2;
				if (a[i][mid] < key) beg = mid + 1;
				else if (a[i][mid] > key) end = mid - 1;
				else {
					flag = 1;
					resrw = i + 1;
					rescl = mid + 1;
					break;
				}
			}
		}
	}
	if (flag == 1)
		printf("The key is located in row %d, column %d\n", resrw, rescl);
	else
		printf("The key is not present\n");
}
