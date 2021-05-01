/* Programme to count the number of vowels and consonants*/
%{
int vow_count=0;
int con_count =0;
%}

%%
[aeiouAEIOU] { vow_count++; } 
[a-zA-Z] { con_count++; }  
%% 

main(int argc, char const *argv[])
{ 
	printf("Enter the string of vowels and consonents\n"); 
	yylex(); 
	printf("The number of vowels are: %d\n",vow_count); 
	printf("The number of consonants are: %d\n",con_count); 
}
