#include<stdio.h>
main()
{
	int i;
	float sum,avg,mrk[5];
	printf("Enter 5 marks\n");
	for(i=0;i<5;i++)
		scanf("%f", &mrk[i]);
	sum=0.0;
	for(i=0;i<5;i++)
		sum=sum+mrk[i];
	avg=sum/5;
	printf("The total is %f\n",sum);
	printf("The average is %f\n",avg);
	printf("RESULT: ");
	if(avg>80) printf("Distinction\n");
	else if (avg>69) printf("Class I\n");
	else if (avg>59) printf("Class II\n");
	else if (avg>49) printf("Class III\n");
	else if (avg>38) printf("Average\n");
	else printf("Fail\n");
}
