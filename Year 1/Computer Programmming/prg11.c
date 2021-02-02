#include<stdio.h>
main()
{
	int i;
	float sum,avg,mrk[15];
	printf("Enter 5 marks\n");
	for(i=0;i<5;i++)
		scanf("%f", &mrk[i]);
	sum=0.0;
	for(i=0;i<15;i++)
		sum=sum+mrk[i];
	avg=sum/15;
	printf("The average is %f",avg);
}
	
