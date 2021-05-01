// Find square root of the number
#include <stdio.h>
#define SQR(x) (x*x)
int main(int argc, char const* argv[]) {
	int a = 5, b = 6, c;
	c = SQR(a);
	printf("c = %d\n", c);

	c = SQR(b);
	printf("c = %d\n", c);
	return 0;
}

