// Write a program to take age and check if oyu are a minor or nt
#include <stdio.h>

void main() {
	int age;
	printf("What is your age?");
	scanf("%d", &age);
	if (age >= 18)
		printf("ADULT\n");
	else
		printf("MINOR\n");
}

/* OUTPUT
	What is your age?21
	ADULT
*/