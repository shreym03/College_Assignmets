//
#include<stdio.h>
main()
{
	int num,i,flag;
	flag=0;
	printf("Enter the number\n");
	scanf ("%d", &num);
	for(i=2;i<(num/2);i++)
		if (num%i==0)
		{
			flag=1;
			break;
		}
	if (flag==1)
		printf("The number is not prime\n");
	else
		printf("The number is prime\n");
}
