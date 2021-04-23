data segment
	num1 db 45h
	num2 db 63h
	res dw ?
data ends
code segment
	assume cs: code, ds: data
	start:
		mov ax, data
		mov ds, ax
		mov ah, 0
		add al, num2
		daa  ;decimal adjust after additition
		adc ah, 0
		mov res, ax
		int 3
	code ends
end start