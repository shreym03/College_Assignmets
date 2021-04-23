;Write a program to compare two arrays and print if they are identical or not
.model small
.stack 20
.data
	arr1 db 'BITS'
	arr2 db 'BITSPILANI'
	len equ 7
	msg1 db 'Identical$'
	msg2 db 'Not Identical$'
.code
start:
	mov ax, @data
	mov ds, ax
	mov es, ax
	lea si, arr1
	mov cx, len
	cld
	repe cmpsb
	jne no
	lea dx, msg1
	jmp disp
	no: lea dx, msg2
	disp: mov ah, 09h
	int 21h
	mov ah, 4ch
	int 21h
end start