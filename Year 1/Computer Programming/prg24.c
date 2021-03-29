// WAP to find the length of the string using loop control
// and print the lenght of the string
#include <string.h>
#include <stdio.h>

void main() {
	char str[30];
	printf("Enter the string\n");
	gets(str);
	int l = 0, i;
	for (i = 0;str[i] != '\0';i++, l++);
	printf("The lenght of the string is %d\n", l);
}

/* OUTPUT
	Enter the string
	aaa
	The length of the string is 3
*/