// WAP to take students ID and generate and print an email address

#include <stdio.h>
#include <string.h>

void generate_email(char idno[], char email[]) {
	int i, j;
	email[0] = 'f';
	for (i = 1;i < 5;i++) email[i] = idno[i - 1];
	for (j = 5;j < 8;j++) email[j] = idno[j + 3];

	strcat(email, "@dubai.bits-pilani.ac.in");
}

void main() {
	char idno[13], emailaddr[40] = "";
	printf("Enter the ID No.\n");
	gets(idno);
	generate_email(idno, emailaddr);
	printf("The ID number of the student is %s \nThe email address is %s\n", idno, emailaddr);
}
