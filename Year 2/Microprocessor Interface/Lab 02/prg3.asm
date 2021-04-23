data segment
	num1 db 89h
	num2 db 7ch
	res dw ?
data ends
code segment
	assume cs: code, ds: data
	start:
		mov ax, data ;Initializing segments
		mov ds, ax
		mov ah, 0
		mov al, num1
		add al, num2
		adc ah, 0 ;Add with carry
		mov res, ax
		int 3 ;Breakpoint interupt
	code ends
end start