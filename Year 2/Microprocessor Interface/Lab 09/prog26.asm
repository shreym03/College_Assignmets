;Write a program to read system date.
.model small
.stack 20
print macro msg
	mov ah, 09h
	mov dx, offset msg
	int 21h
endm
.data
	day db ?, ?, '-'
	month db ?, ?, '-'
	year db ?, ?, ?, ?, '$'
.code
start:
	mov ax, @data
	mov ds, ax
	mov es, ax
	mov ah, 2ah ; function code to get date
	int 21h ; call dos service
	push cx ; saving year
	push dx ; saving day and month 
	mov al, dl
	lea si, day
	mov ah, 00h
	call conv ; to convert day to ascii
	pop dx
	mov al, dh
	lea si, month
	mov ah, 00h
	call conv ; to convert month to ascii
	pop ax
	lea si, year
	call conv ; to convert year to ascii
	print day ; to display date
	mov ah, 4ch
	int 21h
	conv proc near ; procedure convert hexadecimal
		mov cx, 0000h ; day, month and year to bcd
		mov bx, 000ah ; and ascii for display
		next: mov dx, 0000
		div bx ; separating the digits
		add dl, 30h ; converting bcd to ascii
		push dx
		inc cx
		cmp ax, 000ah
		jge next
		add al, 30h
		mov [si], al
		up: 
			pop ax ; putting ascii value in memory
			inc si
			mov [si], al
		loop up
		ret
	conv endp
end start