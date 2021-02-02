//tut-3 Q4
#include<stdio.h>
main()
{
	int a[5],i,j;
	printf("Enter 5 values for an array\n");
	for (i=0;i<5;i++)
		scanf("%d",&a[i]);
	printf("The vale of the matrix is ");
	for(i=0;i<5;i++)
		printf("%d",a[i]);
	printf("\n");
	for(i=0;i<4;i++)
	{
		for(
