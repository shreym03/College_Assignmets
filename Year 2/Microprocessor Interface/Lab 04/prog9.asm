; Write a program to calculate sum of numbers
.model small
.stack 20
.data
	num db 25h, 35h, 45h, 32h, 56h, 98h, 76h, 76h
	sum db ?
	count dw 0008h
.code
start:
	mov ax, @data
	mov ds, ax
	mov cx, count
	mov ax, 0000h
	mov si, 0000h
	repeat:
		add al,num[si]
		jnc next
		add ah, 01
		next: inc si
	loop repeat
	mov sum, ax
	int 3
end start