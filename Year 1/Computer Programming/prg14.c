/*
 *
 */
#include<stdio.h>
main()
{
	int n,sum;
	sum=0;
	while(sum<100)
	{
		printf("Enter a number\n");
		scanf("%d",&n);
		if (n==17)
		{
			printf("\nNumber 17 detected\nProgram terminated\n");
			break;
		}
		printf("The number is %d\n",n);
		sum=sum+n;
	}
	if(sum>=100) printf("The sum has reached 100\n");
}
