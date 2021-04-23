;The Program to rotate the stepper motor by 360 degrees i.e one full round.
.model small ;specify the model for the executable. must for every program.
.stack 100h
.data
	cr equ 0c263h ;user must change the port addresses as assigned by the pc.
	pa equ 0c260h
	pb equ 0c261h
	pc equ 0c262h
	message1 db 'Demonstration program for stepper motor',13,10,'$'
	message2 db 13,10,'The program is running...',13,10,'$'
.code
start:
	mov ax,@data
	mov ds,ax
	mov ah,9h ;display the message line1.
	mov dx, offset message1
	int 21h
	mov ah,9h ;display the message line3.
	mov dx, offset message2
	int 21h
	mov dx,cr
	mov al,80h
	out dx,al
	mov bl,50
	begin: mov al,11h ;to rotate in opposite direction, change the data as 88h instead of 11h
	call out_a
	call delay
	mov al,22h ;to rotate in opposite direction, change the data as 44h instead of 22h
	call out_a
	call delay
	mov al,44h ;to rotate in opposite direction, change the data as 22h instead of 44h
	call out_a
	call delay
	mov al,88h ;to rotate in opposite direction, change the data as 11h instead of 88h
	call out_a
	call delay
	dec bl
	jnz begin
	mov ah,4ch
	int 21h
	out_a:
		mov dx,pa
		out dx,al
		ret
	delay:
		mov cx,0fffh
		d2: mov ax,05ffh
		d1: dec ax
		jnz d1
		dec cx
		jnz d2
		ret
end start ;This is the end of your program