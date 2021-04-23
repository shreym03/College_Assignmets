;Write a program to search a character in the entered string. Display suitable messages on the screen. Read both string and searching character using DOS interrupts.
.model small
.stack 100
print macro msg
mov ah, 09
lea dx, msg
int 21h
endm
.data
msg1 db 0dh, 0ah, 'enter a string:$'
src db 80
	db ?
	db 30 dup (?)
msg2 db 0dh, 0ah, 'enter a character:$'
msg3 db 0dh, 0ah, 'the character is found$'
msg4 db 0dh, 0ah, 'the character is not found $'
.code
start:
	mov ax, @data
	mov ds, ax
	mov es, ax
	print msg1 ; calling a macro to display messages
	lea dx, src
	mov ah, 0ah
	; function code to read string
	int 21h
	print msg2
	mov ah, 01h
	; reading a searching character
	int 21h
	mov cl, src+1
	mov ch, 00
	lea di, src
	add di, 0002
	cld
	repne scasb
	je found
	print msg4
	jmp exit
	found: print msg3
	exit: mov ah, 4ch
	int 21h
end start