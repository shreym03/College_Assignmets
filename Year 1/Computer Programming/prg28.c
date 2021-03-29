// WAP to create a structure to store student's name, age and contact number

#include <stdio.h>
#include <string.h>

struct student {
	char name[50];
	int age;
	char number[15];
};

void main() {
	struct student s1;
	struct student sList[5];
	int i;
	printf("Enter the name, age and contact number for student S1\n");
	scanf("%s", &s1.name);
	scanf("%d", &s1.age);
	scanf("%s", &s1.number);
	printf("Name: %s\nAge: %d\nMobile number: %s\n", s1.name, s1.age, s1.number);
}
