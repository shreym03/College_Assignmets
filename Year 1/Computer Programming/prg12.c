// Write a program to find out what you ranking is based on your average
#include <stdio.h>

void main() {
	int i;
	float sum, avg, mrk[5];
	printf("Enter 5 marks\n");
	for (i = 0;i < 5;i++) scanf("%f", &mrk[i]);
	sum = 0.0;
	for (i = 0;i < 5;i++) sum = sum + mrk[i];
	avg = sum / 5;
	printf("The total is %.1f\n", sum);
	printf("The average is %.2f\n", avg);
	printf("RESULT: ");
	if (avg > 80) printf("Distinction\n");
	else if (avg > 69) printf("Class I\n");
	else if (avg > 59) printf("Class II\n");
	else if (avg > 49) printf("Class III\n");
	else if (avg > 39) printf("Average\n");
	else printf("Fail\n");
}

/* OUTPUT
	Enter 5 marks
	55 65 92 88 76
	The total is 376.0
	The average is 75.20
	RESULT: Class I	
*/