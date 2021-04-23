;The program to emulate an elevator
.model small ;specify the model for the executable. must for every program.
.stack 5000h
.data ;any data declarations here.
	message1 db 'Demonstration program for elevator interface',13,10,'$'
	message2 db 'Press the switchs on the interface and see what happens.',13,10,'$'
	message3 db 'The program is running...',13,10,'press any key to exit.',13,10,'$'
	delayrate dw 04ffh
	cr equ 0c263h
	pa equ 0c260h
	pb equ 0c261h
	pc equ 0c262h
	fcode db 00h,03h,06h,09h
	fclr db 0e0h,0d3h,0b6h,79h
.code ;start your coding here.
	mov ax,@data ;initialize all segment regesters as needed here.
	mov ds,ax
	mov ah,9h ;display the message line1.
	mov dx, offset message1
	int 21h
	mov ah,9h ;display the message line2.
	mov dx, offset message2
	int 21h
	mov ah,9h ;display the message line3.
	mov dx, offset message3
	int 21h
	mov dx,cr
	mov al,082h ;port a input port b out put
	out dx,al
	xor ax,ax
	loop1: mov al,ah
	or al,0f0h
	mov dx,pa
	out dx,al
	mov dx,pb
	loop2: mov ch,ah
	mov ah,01h
	int 16h
	jnz exitp
	mov ah,ch
	in al,dx
	and al,0fh
	cmp al,0fh
	jz loop2
	mov si,00h
	findf: ror al,01h
	jnc found
	inc si
	jmp short findf
	found: mov al,fcode[si]
	cmp al,ah
	ja goup
	jb godn
	clear: mov al,fclr[si]
	mov dx,pa
	out dx,al
	jmp short loop1
	goup: call delay
	inc ah
	xchg al,ah
	or al,0f0h
	mov dx,pa
	out dx,al
	and al,0fh
	xchg ah,al
	cmp al,ah
	jnz goup
	jmp short clear
	godn: call delay
	dec ah
	xchg ah,al
	or al,0f0h
	mov dx,pa
	out dx,al
	and al,0fh
	xchg al,ah
	cmp al,ah
	jnz godn
	jmp short clear
	delay: push cx
	push ax
	mov cx,0ffffh
	loop3: mov ax,0ffffh
	loop4: dec ax
	jnz loop4
	loop loop3
	pop ax
	pop cx
	ret
	exitp: mov ah,4ch
	int 21h