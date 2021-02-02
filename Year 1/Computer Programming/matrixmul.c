#include<stdio.h>
#include<stdlib.h>
int a[50][50],Ar,Ac,b[50][50],Br,Bc;
int mul(int r, int c)
{
	int k,sum=0;
	for(k=0;k<Ac;k++)
	{
		sum+=a[r][k]*b[k][c];
	}
	return sum;
}
void main()
{
	int i,j;
	printf("Enter the number of rows and columns for Matrix A\n");
	scanf("%d %d",&Ar,&Ac);
	printf("Matrix A contains:\n");
	for(i=0;i<Ar;i++)
	{
		for(j=0;j<Ac;j++)
		{
			a[i][j]=rand()%10;
			printf("%d\t",a[i][j]);
		}
		printf("\n");
	}
	printf("Enter the number of rows and columns in Matrix B\n");
	scanf("%d %d",&Br,&Bc);
	printf("Matrix B contains:\n");
	for(i=0;i<Br;i++)
	{
		for(j=0;j<Bc;j++)
		{
			b[i][j]=rand()%10;
			printf("%d\t",b[i][j]);
		}
		printf("\n");
	}
	if(Ac==Br)
	{
		printf("The multiplication of Matrix A and Matrix B is\n");
		for(i=0;i<Ar;i++)
		{
			for(j=0;j<Bc;j++)
				printf("%d\t",mul(i,j));
			printf("\n");
		}
	}
	else printf("The matrices cannot multiply\n");

}
