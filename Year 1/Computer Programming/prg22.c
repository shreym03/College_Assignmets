// Write a program to take print full name of a person
#include <stdio.h>
#include <string.h>

void main() {
	char fname[10], mname[10], lname[10];
	printf("Enter the First name\n");
	gets(fname);  //Similar to scanf but doesn't worry about filling entire string
	printf("Enter the Middle name\n");
	gets(mname);
	printf("Enter the Last name\n");
	gets(lname);
	printf("Your name is %s %s %s\n", fname, mname, lname);
}

/* OUTPUT
	Enter the first name
	John
	Enter the Middle name
	Samuel
	Enter the Last name
	Sanders
	Your name is John Samuel Sanders
*/