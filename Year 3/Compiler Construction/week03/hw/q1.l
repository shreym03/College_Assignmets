/* calculate the total and the average of a set of numbers */
%{
	#include <stdio.h>
	int sum=0;
	float count=0;
	float avg = 0.0;
%}
%%
^[0-9]+$ {
	sum = sum + atoi(yytext);
	count++;
	printf("%s \t count: %d \t current total: %d\n", yytext, (int)count, sum);
}
.	;
%%
int main(int argc,char ** argv){
	yylex();
	avg = sum/count;
	printf("Total Sum: %d\nAverage: %.5f\n",sum,avg);
}
