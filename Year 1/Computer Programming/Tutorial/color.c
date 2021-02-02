#include<stdio.h>
main()
{
	char color;
	scanf ("%c",&color);
	switch(color)
	{
		case 'r':
		case 'R': 
			printf("Red\n");
			break;
		case 'g':
		case 'G':
			printf("Green\n");
			break;
		case'b':
		case'B':
			printf("Blue\n");
			break;
		default:
			printf("Black\n");
			break;
	}	
}
