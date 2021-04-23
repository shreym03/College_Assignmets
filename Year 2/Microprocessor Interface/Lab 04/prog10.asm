.model small
.stack 20
.data
	org 1200h
	array	db 25h, 35h, 45h, 32h, 56h, 98h, 76h, 76h
				db 28h, 56h, 05h, 35h, 00h, 98h, 21h
	org 1220h
	res db ?
	count dw 0016h
.code
start:
	mov ax, @data
	mov ds, ax
	mov cx, count
	mov si, 0000h
	mov al, 25h
	repeat:
		cmp al, array[si]
		jne next
		inc res
		next: inc si
	loop repeat
	int 3
end start