/* Check if the date is in British system or not. Also chheck for leap year */
%{
	#include<stdio.h>
	int date=0;
	int month;
	int year;
%}
%%
^(0[1-9]|1[012])\/(0[1-9]|[12][0-9]|3[01])\/[0-9]+$ {
	strip(yytext);
}
.*       {printf("invalid\n");}
%%
int main(int argc, char **argv){
	yylex();
}
void strip(char *s){
	char temp[100];
	int count=0;
	int j=0;
	for (int i=0;s[i]!='\0';i++){
		if(s[i]=='/'){
			if(count==0){
				month=atoi(temp);
				j=0;
				count++;
			}
			else{
				date=atoi(temp);
				j=0;
				count++;
			}
		}
		else{
			temp[j]=s[i];
			j+=1;
		}
	}
	year=atoi(temp);
	validate(month, date, year);
}
void validate(int month, int date, int year){
	int invalid = 1;
	int leap = check_leap(year);
	switch (month){
		case 4:
		case 6:
		case 9:
		case 11:
			if (date <=30) invalid = 0;
			break;
		case 2: 
			if (((leap==1) && (date<=29)) || (date <= 28)) 
				invalid = 0;
			break;
		default:
			if (date <= 31) invalid = 0;
			break;
	}
	if (invalid == 1)
		printf("The date is invalid\n");
	else
		printf("The date is valid\n The british system is %d/%d/%d\n", date, month, year);
}
int check_leap(int y){
	if ((y%400 == 0) || ((y%100 == 0) && (y%4 == 0)))
		return 1;
	else
		return 0;
}
