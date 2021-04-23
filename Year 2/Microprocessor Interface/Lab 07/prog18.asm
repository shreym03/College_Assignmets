;Write a program to transfer the given string from source to destination using string instruction and also display the destination string.
.model small
.stack 20
.data
	srcstr db 'electronics'
	len dw $-srcstr
	msg db 'the transferred string is'
	dststr db 40 dup ('$')
.code
start:
	mov ax, @data
	mov ds, ax
	mov es, ax
	mov cx, len
	lea si, srcstr
	lea di, dststr
	cld ; for auto increment of si and di
	rep movsb
	lea dx, msg
	mov ah, 09
	int 21h
	mov ah, 4ch
	int 21h
end start