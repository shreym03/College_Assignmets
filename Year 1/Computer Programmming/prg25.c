/*WAP to make function to check if a string is a palindrome or not*/

#include <string.h>
#include <stdio.h>
int ispalindrome(char chk[30])
{
	int l,i;
	l=strlen(chk);
	for(i=0;i<l/2;i++)
	{
		if (chk[i]!=chk[l-i-1])
		return 0;
	}
	return 1;
}

void main()
{
	char str[30];
	int flag;
	printf("Enter the string\n");
	gets(str);
	flag=ispalindrome(str);
	if(flag==1)
		printf("The given string is a palindrome\n");
	else
		printf("The given string is not a palindrome\n");
}
