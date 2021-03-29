// Write a C program to print the ASCII value of an accepted character.
#include <stdio.h>

void main() {
	char c;
	printf("Enter a character\n");
	scanf("%c", &c);
	printf("The ASCII value of %c is %d\n", c, c);
}

/* OUTPUT
	Enter a character
	e
	The ASCII value of e is 101
 */