//
#include<stdio.h>
main()
{
	int sum,n,i;
	sum=0;
	printf("Enter the limit\n");
	scanf ("%d", &n);
	for(i=1;i<=n;i++)
		sum=sum+(i*i*i);
	printf (" The sum of cubes from 1 to %d is %d\n",n,sum);
}
