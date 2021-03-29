// Write a program to check if a given set of marks are identical or not
// 
#include <stdio.h>

void main() {
	int i, flag = 0;
	float mrkA[10], mrkB[10];
	printf("Enter 10 marks for Student A\n");
	for (i = 0; i < 2; i++) scanf("%f", &mrkA[i]);
	printf("Enter 10 marks for Student B\n");
	for (i = 0; i < 2; i++) scanf("%f", &mrkB[i]);
	for (i = 0; i < 2; i++) {
		if (mrkA[i] != mrkB[i]) {
			flag = 1;
			break;
		}
	}
	if (flag) printf("The marks are not identical.");
	else printf("The marks are identical");
}

/* OUTPUT
Enter 10 marks for Student A
1 2 3 4 5 ... 10
Enter 10 marks for Student B
1 2 3 4 5 ... 10
The marks are identical
*/