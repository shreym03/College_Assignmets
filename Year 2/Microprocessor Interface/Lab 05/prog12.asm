;Write a program to convert 4-digit BCD number to HEXADECIMAL number and store the result in memory.
.model small
.stack 20
.data
	bcd dw 1234h
	hex dw 0
.code
start:
	mov ax, @data
	mov ds, ax
	mov ax, 0000h
	mov bx, 0001h	; weight for lsd
	call bcd2bin
	mov bx, 000ah	; weight for 2nd digit
	call bcd2bin
	mov bx, 0064h ; weight for 3rd digit
	call bcd2bin mov bx, 03e8h ; weight for msd
	call bcd2bin
	int 3
	bcd2bin proc near
		mov ax, bcd ; subroutine multiplies digits with
		and ax, 000fh ; respective weights and adds the
		mul bx ; partial product to get equivalent
		add hex, ax ; hex
		mov cl, 04 ; moving the desired digit lsd
		ror bcd, c ; position
	ret
	bcd2bin endp
end start