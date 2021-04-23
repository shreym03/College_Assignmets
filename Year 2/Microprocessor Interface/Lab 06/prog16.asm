;Write a program to  square a single digit hexadecimal number display the result on the screen.
.model small
.stack 20
.code
start:
	mov al, 0fh ;digit to be squared
	mul al
	call disp
	mov ah, 4ch
	int 21h
	disp:
		mov bl, al
		and al, 0f0h
		ror 4
		call hexasc
		mov dl, al
		mov ah, 02
		int 21h
		mov al, bl
		and al, 0fh
		call hexasc
		mov dl, al
		mov ah, 02
		int 21h
		ret
	hexasc:
		cmp al, 0ah
		jb num
		add al, 07h
		num: add al, 30h
		ret
end start