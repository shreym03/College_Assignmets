.model small ;specify the model for the executable. must for every program.
.stack 5000h
.data ;any data declarations here.
	message1 db 'Demonstration program for traffic light interface',13,10,'$'
	message2 db 'The program will change led signals when "," key is pressed on the keyboard.',13,10,'$'
	message3 db 'The program is running...',13,10,'press "enter" key to exit.',13,10,'$'
	cmd_port equ 0c263h
	port_a equ 0c260h
	port_b equ 0c261h
	port_c equ 0c262h
.code ;start your coding here.
	mov ax,@data ;initialize all segemnt regesters as needed here.
	mov ds,ax
	mov ah,9h ;display the message line1.
	mov dx,offset message1
	int 21h
	mov ah,9h ;display the message line2.
	mov dx, offset message2
	int 21h
	mov ah,9h ;display the message line3. mov dx, offset message3 int 21h
	start: mov al,80h ;initialising of ports port a,b and c as o/p
	mov dx,cmd_port
	out dx,al
	again: mov cx,05h
	mov si,offset ports ;store ports address in si reg
	nextst: mov al,cs:[si]
	mov dx,port_a
	out dx,al ;out port the data through port A 
	inc si ;increment to next port address
	inc dx
	mov al,cs:[si]
	out dx,al ;out port the data through port B 
	inc si ;increment to next port address
	inc dx
	mov al,cs:[si]
	out dx,al ;out port the data through port C
	inc si
	push si
	push cx
	wser: nop ;keyboard mode
	push ax
	mov ah,0h ;read key "," for increment to next data
	int 16h
	cmp al,','
	jne wser
	pop ax ;sequence for turning ON ;amber led
	pop cx
	pop si
	mov al, cs:[si]
	mov dx,port_a
	out dx,al
	inc si
	inc dx
	mov al,cs:[si]
	out dx,al
	inc si
	inc dx
	mov al,cs:[si]
	out dx,al
	inc si
	call delay ;call for delay routen
	push ax
	mov ah,0h
	int 16h
	cmp al,0dh
	jne l1
	mov ax,4c00h
	int 21h
	l1: pop ax
	loop nextst
	jmp again
	delay: mov bl,0fh
	push cx ;delay routen
	dly5: mov cx,1fffh
	dly10: nop
	loop dly10
	dec bl
	jnz dly5
	pop cx
	ret
ports:
	db 88h,83h,0f2h ; state 1
	db 88h,87h,0f2h ; all ambers on
	db 38h,88h,0f4h ; state 2
	db 78h,88h,0f4h ; all ambers on
	db 83h,88h,0f8h ; state 3
	db 87h,88h,0f8h ; all ambers on
	db 88h,38h,0f1h ; state 4
	db 88h,78h,0f1h ; all ambers on 
	db 88h,88h,00h ; state 5
	db 88h,88h,00h ; all ambers on
end