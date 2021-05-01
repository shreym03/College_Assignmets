/**
 * Write a C program to test out the optamized method of C compiler
*/
#include <stdio.h>
#include <math.h>
double powern(double d, unsigned n) {
	double x = 1.0;
	unsigned j;
	for (j = 1; j <= n; j++)
		x *= d;
	return x;
}

int main(void) {
	double sum = 0.0;
	unsigned i;
	for (i = 1; i <= (1000000000); i++)
		sum += powern(i, i % 5);
	printf("sum = %g\n", sum);
	return 0;
}

/*
 gcc -O0 optamize.c
 gcc -O optamize.c
 gcc -O2 optamize.c
 gcc -O3 optamize.c
 gcc -O4 optamize.c
*/