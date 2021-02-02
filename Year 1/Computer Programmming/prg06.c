#include<stdio.h>
void main()
{
	int l2=0,l1=1,next,n,i;// l2 is second last no.,l1 is last no.
	printf("Enter the upper limit of the fibonacci series\n");
	scanf("%d",&n);
	printf("%d %d ",l2,l1);
	next=l2+l1;
	while(next<=n)
	{
		printf("%d ",next);
		l2=l1;
		l1=next;
		next=l2+l1;
	}
	printf("\n");
}
