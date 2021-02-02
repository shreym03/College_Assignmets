// tut 4 q3
#include<stdio.h>
main()
{
	int a[50][50],m,n,i,j,k,key, flag=0, beg,end, mid, resrw, resclmn;
	printf("Enter the number of rows and columns of 2D-array\n");
	scanf("%d %d",&m,&n);
	printf("Enter %d values into the array (IN ORDER)\n",m*n);
	for(i=0;i<m;i++)
		for(j=0;j<n;j++)
			scanf("%d", &a[i][j]);
	printf("Enter the key that is to be searched\n");
	scanf("%d", &key);
	for(i=0;i<m && flag==0;i++)
	{ 
		if(key>=a[i][0]&& key<=a[i][n-i])
		{
			beg=0;
			end=n-1;
			while(beg<=end)
			{
				mid=(beg+end)/2;
				if(a[i][mid]<key)
					beg=mid+1;
				else if (a[i][mid]>key)
					end= mid-1;
				else
				{
					flag=1;
					resrw=i+1;
					resclmn=mid+1;
					break;
				}
			}
		}
	
	}
	if(flag==1)
		printf("The key is located in row %d, column %d\n",resrw,resclmn);
	else
		printf("The key is not present\n");
	
}
