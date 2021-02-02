// 
#include<stdio.h>
main()
{
	float base, hra, allow, sal;
	printf ("Input your basic and allowance");
	scanf("%f%f", &base, &allow);
	hra=.4*base;
	printf("The value ofyour HRA is %f\n", hra);
	sal=hra+base+allow;
	printf("Your salary is %f\n",sal);
}
