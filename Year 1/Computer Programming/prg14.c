// Write a program to keep taking numbers until the total sum is greater than or equal to 100.
//  If 17  is entered, the program will be terminated
#include <stdio.h>

void main() {
	int n, sum;
	sum = 0;
	while (sum < 100) {
		printf("Enter a number\n");
		scanf("%d", &n);
		if (n == 17) {
			printf("\nNumber 17 detected\nProgram terminated\n");
			break;
		}
		sum = sum + n;
		printf("The number is %d\n", n);
		printf("The sum is %d\n", sum);
	}
	if (sum >= 100) printf("The sum has reached 100\n");
}

/* OUTPUT
	Enter a number
	20
	The number is 20
	The sum is 20
	Enter a number
	20
	The number is 20
	The sum is 40
	Enter a number
	20
	The number is 20
	The sum is 60
	Enter a number
	20
	The number is 20
	The sum is 80
	Enter a number
	20
	The number is 20
	The sum is 100
	The sum has reached 100
*/