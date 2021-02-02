#include<stdio.h>
main()
{
	int age;
	printf("What is your age?");
	scanf("%d",&age);
	if (age>=18)
		printf("MAJOR\n");
	else
		printf("MINOR\n");
}
