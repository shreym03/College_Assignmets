/* Check if folllows integer format of numbers */
digit [0-9]+
optionalfraction "."{digit}
optionalexponent "E"("+"|"-")?{digit}
number {digit}{optionalfraction}?{optionalexponent}?
%%
{number} {printf("Accepted %s\n",yytext);}
.* {printf("Not accepted\n");} 
%%
