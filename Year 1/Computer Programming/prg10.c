#include<stdio.h>
#include<math.h>
void main()
{
	int n,i;
	float series1=0,series2=0,series3=0;
	printf("Enter upper limit\n");
	scanf("%d",&n);
	for(i=0;i<=n;i++)
	{
		series1+=1/pow(2,i);
		series2+=(3+2*i)/pow(2,i);
		series3+=(pow(-1,i)*(3+2*i))/pow(2,i);
	}
	printf("The sum of first series is %f \nThe sum of second series is %f \nThe sum of third series is %f\n",series1,series2,series3);
}
