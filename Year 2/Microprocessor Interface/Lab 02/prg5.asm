.model small
.data
	num1 db 80h
	num2 db 76h
	res dw ?
.code
start:
	mov ax, @data
	mov ds, ax
	mov ah, 0
	mov al, num1
	add al, num2
	adc res,0
	mov res, ax
	int 3
end start