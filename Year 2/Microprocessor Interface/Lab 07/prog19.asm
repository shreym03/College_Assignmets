;Write a program to read two digit decimal number using keyboard and search whether the number is present in an array or not. Display suitable message.
.model small
.stack 20
.data
	array db 35h, 56h, 82h, 89h, 90h, 23h, 12h, 51h, 88h
	len dw $-array
	msg1 db 0dh, 0ah, 'enter two digit number: $'
	msg2 db0dh, 0ah, 'the number is present $'
	msg3 db 0dh, 0ah, 'the number is not present $'
.code
start:
	mov ax, @data
	mov ds, ax
	mov es, ax
	mov cx, len
	lea dx, msg1
	mov ah, 09
	int 21h
	call readkb
	ror al, 4 ; shifting the digit to msd position
	mov bl, al
	call readkb
	add al, bl ; to make 2-digit number
	lea dx, msg2
	lea di, array
	cld
	repne scasb ; compares al with memory pointed by di
	je go 
	lea dx, msg3
	go: mov ah, 09
	int 21h
	mov ah, 4ch
	int 21h
	readkb proc near
		mov ah, 01 ; accepting number from keyboard
		int 21h
		cmp al, 3ah
		jc sub30 
		sub al, 07h
		sub30: sub al, 30h ; ascii to hex conversion
		ret
	readkb endp
end start