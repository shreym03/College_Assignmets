%{
  #include<stdio.h>
  int count0 = 0, count1 = 0;
%}
%token ZERO ONE END
%%

L:
  L S END {
    printf("Accepted\n");
    printf("Count of 0 = %d\nCount of1 = %d\n", count0, count1);
    count0 = 0;
    count1 = 0;
  }
  |  {}
  | L error END {
    count0 = 0;
    count1 = 0;
  }
  ;

S:
  ONE A
  {
    count1++;
  }
  ;
A:
  ZERO S {
    count0++;

  }
  | ZERO {
    count0++;
  }
  | ONE S {
    count1++;
  }
  ;
%%
int yyerror(char *msg){
  printf("Error in input \n%s\n", msg);
  return 0;
}

int main(){
  yyparse();
}

