%{
#include <stdio.h>
#include "y.tab.h"
int yylval;
%}
delim [ \t\n]
ws {delim}+
digit	[0-9]
number {digit}+
letter [a-zA-Z]
letter_ [letter_]
id {letter_}({letter_}|{digit})*
%%
{ws}	{}
"+"	{return Plus;}
"-"	{return Minus;}
"*"	{return Mult;}
"/"	{return Div;}
{id} 	{ return Id;}
";" {return Semicolon;}
{number} {yylval = atoi(yytext); return Number;}
. { printf ("yylex:error:%s:\n", yytext);}
%%
