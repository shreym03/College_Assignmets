#include<stdio.h>
main()
{
	int a[100][100],i,j,n;
	printf("Enter the number of rows in square matrix\n");
	scanf("%d",&n);
	printf("Enter %d values for the square matrix (In order)\n",n*n);
	for(i=0;i<n;i++)
		for(j=0;j<n;j++)
			scanf("%d",&a[i][j]);
	int sumdg=0, sumupr=0, max[n];
	for(i=0;i<n;i++)
	{
		max[i]=a[i][0];
		for(j=0;j<n;j++)
		{
			if(i==j) 
				sumdg+=a[i][j];
			if ((i+j)<n) 
				sumupr+=a[i][j];
			if(a[i][j]>max[i])
				max[i]=a[i][j];
		}
	}
	printf("The sum of Diagonals is %d \nThe sum of upper triangle is %d \n",sumdg,sumupr);
	for (i=0;i<n;i++)
		printf("The highest value in row %d is %d\n",i+1,max[i]);
	printf("The transpose of the given matrix is\n");
	for(i=0;i<n;i++)
	{
		for (j=0;j<n;j++)
			printf("%d\t",a[j][i]);
		printf("\n");
	}
}
