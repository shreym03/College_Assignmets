;Write a program to exchange two data blocks of length 10-bytes stored in memory starting from 1200H and 1220H respectively.
.model small
.stack 20
.data
	org 1200h
	array1	db 05h, 15h, 25h, 35h, 45h 
	       	db 55h, 65h, 75h, 85h, 95h
	org 1220h
	array2	db 0a1h, 0a2h, 0a3h, 0a4h, 0a5h
					db 0a6h, 0a7h, 0a8h, 0a9h, 0aah
	count dw 000ah
.code
start:
	mov ax, @data
	mov ds, ax
	mov cx, count
	mov si, 0000h
	repeat:
		mov al, array1[si]
		xchg al, array2[si]
		mov array1[si], al
		next: inc si
	loop repeat
	int 3
end start