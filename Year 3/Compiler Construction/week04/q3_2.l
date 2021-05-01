lower [a-z]
upper [A-Z]
%%
[ \t\n] ECHO;
{lower} { printf("%c",yytext[0]-32); }
{upper} { printf("%c",yytext[0]+32); }
. ECHO;
%%
int main(int argc, char const *argv[]) {
	printf("Enter the string\n");
	yylex();
}
