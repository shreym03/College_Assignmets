#include<stdio.h>
#include<string.h>
#include<ctype.h>
#define max 5

typedef struct
{
	char idno[13];
	char name[50];
	char gender;
	char resident;
	float cgpa;
	char emailaddr[33];
} student;

void populate_records(student arr[])
{
	int i;
	for(i=0;i<max;i++)
	{
		scanf("%[^,]s",arr[i].idno);
		getchar();
		scanf("%[^,]s",arr[i].name);
		getchar();
		scanf("%[^,]c",arr[i].gender);
		getchar();
		scanf("%[^,]c",arr[i].resident);
		getchar();
		scanf("%[^,]f",arr[i].cgpa);
		getchar();
	}
}


void generate_email(char idno[], char email[])
{
	int i,j;
	email[0]='f';
	for(i=1;i<5;i++)
	{
		email[i]=idno[i-1];
	}
	for(j=5;j<8;j++)
	{
		email[j]=idno[j+3];
	}
	email[8]='\0';
	strcat(email,"@dubai.bits-pilani.ac.in");
}

void print_records(student arr[])
{
	int i;
	for(i=0;i<max;i++)
	{
		printf("%d %s %s\n",i+1,arr[i].idno,arr[i].name);
		printf("Gender:");
		switch (arr[i].gender)
		{
			case 'M':
				printf("Male\n");
				break;
			case 'F':
				printf("Female\n");
				break;
		}
		printf("Residence status:");
		switch (arr[i].resident)
		{
			case 'H':
				printf("Hosteler\n");
				break;
			case 'D':
				printf("Day Scholar\n");
				break;
		}
		printf("CGPA: %f\n",arr[i].cgpa);
		generate_email(arr[i].idno,arr[i].emailaddr);
		printf("Email address: %s",arr[i].emailaddr);
	}
}


float avg_cgpa(student arr[])
{
	float avg,sum=0;
	int i;
	for(i=0;i<max;i++)
		sum+=arr[i].cgpa;
	avg=sum/max;
	return avg;
}

void gender_count(student arr[])



void main()
{
	student stdarr[max];
}
