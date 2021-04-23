;Write a program to accept a string and a substring. Print if substrinng is present in string or not
.model small
.stack 20
read macro str
	lea dx, str
	mov ah, 0ah
	int 21h
endm
print macro msg
	mov ah, 09h
	lea dx, msg
	int 21h
endm
.data
	mainstr db 80
		 	db ?
		 	db 75  dup(?)
	subs db 40
		db ?
		db 35 dup(?)
	msg1 db 0dh, 0ah, 'Enter the string: $'
	msg2 db 0dh, 0ah, 'Enter the substring: $'
	msg3 db 0dh, 0ah, 'substring is present $'
	msg4 db 0dh, 0ah, 'substring is not present: $'
.code
start:
	mov ax, @data
	mov ds, ax
	mov es, ax
	cld
	print msg1
	read mainstr
	print msg2
	read subs
	mov dl, mainstr+1
	mov dh, 0
	mov bx, dx
	mov dl, subs+1
	mov cx, dx
	lea bx, mainstr+2
	again: mov si, bx
	push cx
	repe cmpsb
	pop cx
	je found
	inc bx
	dec bp
	jnz again
	print msg4
	jmp exit
	found: print msg3
	exit: mov ah, 4ch
	int 21h
end start
