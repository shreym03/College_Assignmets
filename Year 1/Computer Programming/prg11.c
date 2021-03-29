// Write a program to calculate the sum of 4 marks
#include <stdio.h>

void main() {
	int i;
	float sum, avg, mrk[5];
	printf("Enter 5 marks\n");
	for (i = 0; i < 5; i++) scanf("%f", &mrk[i]);
	sum = 0.0;
	for (i = 0; i < 5; i++) sum = sum + mrk[i];
	avg = sum / 5;
	printf("The average is %.2f\n", avg);
}

/* OUTPUT
	Enter 5 marks
	55 65 92 88 76
	The average is 75.20
*/