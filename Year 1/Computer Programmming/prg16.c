#include<stdio.h>
main()
{
	float i,y,x;
	printf("Y\t\t X\t\t I\n");
	for(y=1;y<=6;y++)
	{
		for(x=5.5;x<=12.5;x+=.5)
		{
			i=2+(y+.5*x);
			printf("%f\t %f\t %f\n",y,x,i);
		}
	}
}
