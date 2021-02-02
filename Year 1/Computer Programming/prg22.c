#include<stdio.h>
#include<string.h>
void main()
{
	char fname[30],mname[30],lname[30];
	printf("Enter the First name\n");
	gets(fname);
	//Similar to scanf("%s",name) but doesn't worry about filling entire string
	printf("Enter the Middle name\n");
	gets(mname);
	printf("Enter the Last name\n");
	gets(lname);
	printf("Your name is %s %s %s\n",fname,mname,lname);
}	 
