// Write a C program to display the spelling of inputed number between 1 and 10
#include <stdio.h>

void main() {
	int num;
	printf("Enter the number\n");
	scanf("%d", &num);
	switch (num) 	{
	case 1:
		printf("One\n");
		break;
	case 2:
		printf("Two\n");
		break;
	case 3:
		printf("Three\n");
		break;
	case 4:
		printf("Four\n");
		break;
	case 5:
		printf("Five\n");
		break;
	case 6:
		printf("Six\n");
		break;
	case 7:
		printf("Seven\n");
		break;
	case 8:
		printf("Eight\n");
		break;
	case 9:
		printf("Nine\n");
		break;
	case 10:
		printf("Ten\n");
		break;
	default:
		printf("Invalid Input\n");
		break;
	}
}

/* OUTPUT
	Enter the number
	7
	Seven

	Enter the number
	21
	Invalid Input
*/