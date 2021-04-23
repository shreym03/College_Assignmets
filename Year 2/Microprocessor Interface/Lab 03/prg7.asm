.model small
.stack 20
.data
	num1 db 89h,35h,45h,32h,56h,98h,76h,76h
	num2 db 32h,56h,43h,75h,89h,10h,34h,22h
	ans db 9 dup(0)
	count dw 8h
.code
start:
	mov ax, @data
	mov ds, ax
	mov cx, count
	mov si, 0h
	clc
	repeat:
		mov al, num1[si]
		sbb al, num2[si] ;subtrction with borrow
		mov ans[si], al
		inc si
	loop repeat
	int 3
end start