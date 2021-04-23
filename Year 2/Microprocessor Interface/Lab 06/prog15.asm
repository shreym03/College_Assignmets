;Write a program to display the hexadecimal byte 45H on the screen using DOS interrupts.
.model small
.stack 20
.code
start:
	mov al, 45h ; number to be displayed
	mov bl, al
	and al, 0f0h ; get upper digit (nibble)
	ror al, 4  ;shifts to right by 4 bytes. same as shifting uppper digit to lower digit
	call hexasc ; convert from hex to ascii
	mov dl, al ; display first digit
	mov ah, 02 ; function code to display single character
	int 21h 
	mov al, bl
	and al, 0fh ; get lower digit
	call hexasc
	mov dl, al ; display second digit
	mov ah, 02
	int 21h 
	mov ah, 4ch ; dos interrupt to terminate process
	int 21h
	hexasc:
		cmp al, 0ah
		jb num ;jump if below
		add al, 07 ; for a-f, add 37h
		num: add1 al, 30h ; for 0-9, add 30h
	ret
end start