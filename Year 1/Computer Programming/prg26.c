/*WAP to print frst,middle and last name, concatenate the and print as a full name*/

#include <string.h>
#include <stdio.h>
void main()
{
	char fname[30],mname[30],lname[30], fullnm[95];
	printf("Enter the First name\n");
	gets(fname);
	printf("Enter the Middle name\n");
	gets(mname);
	printf("Enter the Last name\n");
	gets(lname);
	strcpy(fullnm,fname);
	strcat(fullnm," ");
	strcat(fullnm,mname);
	strcat(fullnm," ");
	strcat(fullnm,lname);
	printf ("The full name is %s\n",fullnm);
}
