/* Convert the cases from upper to lower and vice versa */
lower [a-z]
upper [ A-Z]
%%
[\t\n]+ ;
[" "] {
	printf(" ");
}
{lower} {
	printf("%c",yytext[0]-32);
}
{upper} {
	printf("%c",yytext[0]+32);
}
. ;
%%
int main(int argc, char const *argv[]) {
	printf("Enter the string\n");
	yylex();
}
