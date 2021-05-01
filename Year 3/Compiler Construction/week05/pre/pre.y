%{
  #include <stdio.h>
  #include <stdlib.h>
  #include <ctype.h>
%}
%token Number
%token Plus Minus Mult Div
%token Semicolon Id
%%
lines:
    lines expression Semicolon {
    printf("The prefix expression is %d\n", $2);
    printf( "Please enter yet another prefix expr ending with ; or <ctrl-d> to quit : \n");
    }
  | lines Semicolon
  | {printf( "Please enter yet another prefix expr ending with \";\" or <ctrl-d> to quit : \n");}
  ;
expression:
    Plus expression expression {$$ = $2 + $3;}
  | Minus expression expression {$$ = $2 - $3;}
  | Mult expression expression {$$ = $2 * $3;}
  | Div expression expression {$$ = $2 / $3;}
  | Number {$$ = $1;}
  ;
%%
void yyerror(char *msg){
  printf("Error in input %s\n", msg);
  exit(1);
}
int main(){
  yyparse();
}
