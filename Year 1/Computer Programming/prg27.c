/*WAP to input a string and find the number of vowels and consonants present in string*/

#include <string.h>
#include <stdio.h>

void main() {
	char str[30];
	int i, l, vow = 0, cons = 0;
	printf("Enter string value\n");
	gets(str);
	l = strlen(str);
	for (i = 0;i < l;i++) {
		switch (str[i]) {
		case 'a':
		case 'A':
		case 'e':
		case 'E':
		case 'i':
		case 'I':
		case 'o':
		case 'O':
		case 'u':
		case 'U':
			vow++;
			break;
		default:
			cons++;
			break;
		}
	}
	printf("The number of vowels is %d\nThe number of consonants is %d\n", vow, cons);
}
