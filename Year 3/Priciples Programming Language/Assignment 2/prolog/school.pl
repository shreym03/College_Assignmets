student(s001,aaa).
student(s002,bbb).
student(s003,ccc).
student(s004,ddd).
student(s005,eee).

skill(s001,music).
skill(s002,swimming).
skill(s001,dance).
skill(s004,dance).
skill(s001,swimming).
skill(s003,music).
skill(s005,music).

language(s001,tamil).
language(s002,kannada).
language(s002,punjabi).
language(s004,hindi).
language(s001,telugu).
language(s003,urdu).
language(s005,kokani).

printtb1:-
	write('Skey'),write('	'),
	write('Sname'),nl.
findstudent(SKEY):-
	printtb1,
	student(SKEY,Y),
	write(SKEY),write('	'),
	write(Y),nl.

printtb2:-
	write('Skey'),write('	'),
	write('Skill'),nl.
findskill(SKEY):-
	printtb2,
	skill(SKEY,Y),
	write(SKEY),write('	'),
	write(Y),nl.

printtb3:-
	write('Skey'),write('	'),
	write('Language'),nl.
findlang(SKEY):-
	printtb3,
	language(SKEY,Y),
	write(SKEY),write('	'),
	write(Y),nl.

printtb4:-
	write('Skey'),write('	'),
	write('Language'),write('	'),
	write('Skill'),nl.
tb4(SKEY):-
	printtb4,
	student(SKEY,_),skill(SKEY,Z),language(SKEY,W),
	write(SKEY),write('	'),
	write(W),write('	'),
	write(Z),nl.
findkey(SKEY):-
	findall(SKEY,tb4(SKEY),L).
