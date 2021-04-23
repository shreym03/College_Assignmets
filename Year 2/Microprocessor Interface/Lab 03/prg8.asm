;Write a program to multiply two 8-bit binary numbers stored in memory and also store the result in memory (both unsigned and signed operation).
.model small
.stack 20
.data
	n1 db 35h
	n2 db 82h
	Un_sign_prod dw ?
	Sign_prod dw ?
.code
start: 
	mov ax, @data ; Initialize DS 
	mov ds, ax
	mov al, n1
	mul n2 ; Unsigned multiplication
	mov un_sign_prod, ax
	mov al, n1
	imul n2 ; Signed multiplication
	mov sign_prod, ax
	int 3
end start