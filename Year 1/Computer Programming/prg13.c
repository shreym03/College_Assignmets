#include<stdio.h>
main()
{
	int i;
	float mrkA[10],mrkB[10],flag=0;
	printf("Enter 10 marks for Student A\n");
	for(i=0;i<10;i++)
		scanf("%f", &mrkA[i]);
	printf("Enter 10 marks for Student B\n");
	for(i=0;i<10;i++)
		scanf("%f", &mrkB[i]);
	for(i=0;i<10;i++)
		if(mrkA[i]!=mrkB[i])
		{
			flag=1;
			break;
		}
	if (flag==0)
		printf("The marks are identical. FULL ON CHEATING");
	else
		printf("The marks are not identical");
}
