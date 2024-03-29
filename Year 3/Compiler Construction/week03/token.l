/* Token checker */
%{
#include<stdio.h>
int lineno = 1;
%}
letter [a-zA-z]
digit [0-9]
ident {letter}({letter}|{digit})*
number {digit}+
quote \"
literal {quote}({digit}|{letter})+{quote}
%%
\n {lineno = lineno+1;} 
"=" {printf("operator =\n");}
"if" {printf("keyword IF in line number %d\n",lineno);}
"else" {printf("keyword ELSE in %d\n",lineno);}
"switch" {printf("keyword SWITCH \n");}
{ident} {printf("identifier %s of length %d\n",yytext,yyleng);}
{number} {printf("number constant %s\n",yytext);}
{literal} {printf("literal %s\n",yytext);}
.* {}
%%
