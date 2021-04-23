;Write a program to read system time and display at the centre of the screen
.model small
.stack 20
.data
	ms db "Present time is: $"
.code
start:
	mov ax, @data
	mov ds, ax
	mov ah, 00 ; function code to clear screen
	mov al, 03h ; text video mode
	int 10h ; calling bios interrupts

	mov ah, 02 ; function code to set cursor position
	mov bh, 0 ; video page number
	mov dh, 12 ; row number
	mov dl, 30 ; column number
	int 10h

	lea dx, ms
	mov ah, 09
	int 21h
	mov ah, 2ch ; function code to read the system time
	int 21h

	mov al, ch ; to display hour
	call disp
	mov dl, ':'
	mov ah, 02
	int 21h

	mov al, cl ; to display minute
	call disp
	mov dl, ':'
	mov ah, 02
	int 21h

	mov al, dh ; to display second
	call disp
	
	mov ah, 02 ; to bring cursor to bottom of screen
	mov bh, 0
	mov dh, 24 ; row
	mov dl, 00 ; column
	int 10h
	mov ah, 4ch
	int 21h
	disp proc near
		aam
		add ax, 3030h
		mov bx, ax
		mov dl, bh
		mov ah, 02
		int 21h
		mov dl, bl
		mov ah, 02
		int 21h
		ret
	endp
end start