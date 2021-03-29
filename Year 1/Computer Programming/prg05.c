// WAP to print all ASCII values and their equivalent character using WHILE loops.
//The ASCII values from 0 to 255

#include <stdio.h>
void main() {
	int i;
	char c;
	i = 0;
	while (i <= 255) 	{
		c = i;
		printf(" The ASCII value of %d is %c\n", i, c);
		i++;
	}
}

/* OUTPUT
`...
 The ASCII value of 33 is !
 The ASCII value of 34 is "
 The ASCII value of 35 is #
 The ASCII value of 36 is $
 The ASCII value of 37 is %
 The ASCII value of 38 is &
 The ASCII value of 39 is '
 The ASCII value of 40 is (
 The ASCII value of 41 is )
 ...
*/