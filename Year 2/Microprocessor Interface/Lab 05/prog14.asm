;Write a program to convert the given ASCII byte to HEXADECIMAL digit and store the result in memory.
.model small
.stack 20
.data
	ascii db 38h
	hex_digit db ?
.code
start:
	mov ax, @data
	mov ds, ax
	mov al, ascii
	cmp al, 3ah ; to see whether it is between 30h
	jc sub30 ; to 39h or 41h to 46h
	sub al, 07h
	sub30: sub al, 30h ; converting to hex digit
	mov hex_digit, al
	int 3
end start