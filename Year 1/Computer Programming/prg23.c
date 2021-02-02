/*WAP to get string inputs. Compare two strings using string functions and print if strings are equal or not*/
#include <string.h>
#include <stdio.h>
void main()
{
	char str1[30],str2[30];
	int x;
	printf("Enter the first string value\n");
	gets(str1);
	printf("Enter the second string value\n");
	gets(str2);
	x=strcmp(str1,str2);
	if (x==0)
		printf("The strings are equal!\n");
	else
		printf("The srings are not equal\n");
}
