;Write a program to read a string using DOS interrupts, reverse the entered string and display the same on the screen. Use MACRO for display.
.model small
.stack 20
disp macro msg
	mov ah, 09h
	mov dx, offset msg
	int 21h
endm
.data
	msg1 db 0dh, 0ah, 'input a string:$'
	src db 80 ; maximum size of the string
		db ? ; actual size of the string
		db 30 dup (?) ; to store actual string
	msg2 db 0dh, 0ah, 'the reversed string is:'
	rev db 30 dup (?)
.code
start: 
	mov ax, @data
	mov ds, ax
	mov es, ax
	disp msg1
	mov dx, offset src
	mov ah, 0ah ; function code to read a string
	int 21h
	mov si, offset src+2
	mov di, offset rev-1
	mov cl, src+1 ; length of the string
	mov ch, 00
	add di, cx
	mov byte ptr[di+1], '$' ; end character for function 09h
	cld
	next: movsb
		sub di, 0002
	loop next
	disp msg2
	mov ah, 4ch
	int 21h
end start