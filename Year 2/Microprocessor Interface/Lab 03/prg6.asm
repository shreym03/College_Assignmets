.model small
.data
num1 db 23h, 35h, 45h, 32h, 56h, 98h, 76h, 76h
num2 db 90h, 50h, 43h, 75h, 89h, 10h, 34h, 22h
ans db 10 dup(?)
count dw 8h
.code
start:
	mov ax, @data
	mov ds, ax
	mov cx, count
	mov si, 0h
	clc ;clear carr flag
	repeat:
		mov al, num1[si]
		adc al, num2[si]
		mov ans[si], al
		inc si
	loop repeat
	mov al, 00h
	adc al, 00h
	mov ans[si], al
	int 3
end start