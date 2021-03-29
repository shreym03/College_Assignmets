// Write a program to print out sum of 3 different series
#include <stdio.h>
#include <math.h>

void main() {
	int n, i;
	float s1 = 0, s2 = 0, s3 = 0;
	printf("Enter upper limit\n");
	scanf("%d", &n);
	for (i = 0;i <= n;i++) 	{
		s1 += 1 / pow(2, i);
		s2 += (3 + 2 * i) / pow(2, i);
		s3 += (pow(-1, i) * (3 + 2 * i)) / pow(2, i);
	}
	printf("The sum of First series is %.3f \nThe sum of Second series is %.3f \nThe sum of Third series is %.3f\n", s1, s2, s3);
}

 /* OUTPUT
	Enter upper limit
	5
	The sum of First series is 1.969 
	The sum of Second series is 9.469 
	The sum of Third series is 1.406
 */