// WAP to print all ASCII values and their equivalent character using WHILE loops.
//The ASCII values from 0 to 255

#include<stdio.h>
main()
{
	int i;
	char c;
	i=0;
	while(i<=255)
	{
		c=i;
		printf(" The ASCII value of %d is %c\n",i,c);
		i++;
	}
}
