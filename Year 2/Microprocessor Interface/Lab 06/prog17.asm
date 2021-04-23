;Write a program to input two single-digit hex numbers from keyboard and display their product on the screen.
.model small
.stack 20
.code
start: 
	call readkb
	mov bl, al
	call nxtline
	call readkb
	mul bl
	mov bl, al
	call nxtline
	call disp
	mov ah, 4ch
	int 21
	readkb proc near
		mov ah, 01 ; accepting number from keyboard
		int 21h
		call aschex
		ret
	readkb endp
	aschex proc near
		cmp al, 3ah
		jc sub30
		sub al, 07h
		sub30: sub al, 30h ; ascii to hex conversion
		and al,0fh
	ret
	aschex endp
	nxtline proc near
		mov ah, 2
		mov dl, 0ah ; line feed
		int 21h
		mov dl, 0dh ; carriage return
		int 21h
		ret
	nxtline endp
	disp proc near
		mov al, bl
		and al, 0f0h
		ror al, 4
		call hexasc
		mov dl, al
		mov ah, 02
		int 21h
		mov al, bl
		and al, 0fh
		call hexasc
		mov dl, al
		mov ah, 02
		int 21h
		ret
	disp endp
	hexasc proc near
		cmp al, 0ah
		jb num
		add al, 07
		num: add al, 30h
		ret
	hexasc endp
end start