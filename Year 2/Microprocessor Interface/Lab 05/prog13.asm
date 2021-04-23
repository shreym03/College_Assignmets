;Write a program to convert hexadecimal numbers to grey code using XLAT 
.model small
.stack 20
.data
	grey_table 	db 00h, 01h, 03h, 02h, 06h, 07h, 05h, 04h, 0ch, 0dh
			   			db 0fh, 0eh, 0ah, 0bh, 09h, 08h
	hex_num db 07h
	grey_code db ?
.code
start:
	MOV ax, @data
	MOV ds, ax
	MOV bx, offset grey_table
	MOV al, hex_num
	XLAT
	MOV grey_code, al
	INT 3
end start