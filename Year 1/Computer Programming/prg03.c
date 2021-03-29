// Write a C program to calculate  the HRA (House Rent Allowance) and total salary based on basic salary and bonus allowance
#include <stdio.h>
void main() {
	float base, hra, allow, sal;
	printf("Input your basic and allowance: ");
	scanf("%f%f", &base, &allow);
	hra = 0.4 * base;
	printf("The value of your HRA is %.2f\n", hra);
	sal = hra + base + allow;
	printf("Your salary is %.2f\n", sal);
}

/* OUTPUT
	Input your basic and allowance: 20 30
	The value of your HRA is 8.00
	Your salary is 58.00
*/