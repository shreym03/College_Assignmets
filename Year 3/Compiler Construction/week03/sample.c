#include <stdio.h>
main() {
    int a, b, sum;
    float c, d, diff;
    printf("Enter two integers: ");
    scanf("%d%d", &a, &b);
    printf("Enter 2 float numbers: ");
    scanf("%f%f", &c, &d);
    sum = a + b;
    diff = c - d;
    printf("The Sum is %d\nThe Difference is %f\n", sum, diff);
}
