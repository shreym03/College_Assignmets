/* Calculate the Odd and Even sum of a set of numbers */
%{
	#include <stdio.h>
	int odd=0;
	int even=0;
	int temp;
%}
%%
^[+-]?[0-9]*[02468]$ {
	temp=atoi(yytext);
	even=even + temp;
	printf("%s\tEven", yytext);
}
^[+-]?[0-9]*[13579]$ {
	temp=atoi(yytext);
	odd=odd + temp;
	printf("%s\tOdd", yytext);
}
.       ;
%%
int main(int argc, int **argv){
	yylex();
	printf("\nOdd sum: %d\nEven sum: %d\n",odd,even);
}
