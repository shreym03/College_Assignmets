;Write a program to create a file and write text data into it using DOS interrupts.
.model small
.stack 20
print macro msg
	mov ah, 09h
	lea dx, msg
	int 21h
endm
read macro str
	lea dx, str
	mov ah, 0ah
	int 21h
endm
.data
	msg1 db 0dh, 0ah, 'enter a file name:$'
	msg2 db 0dh, 0ah, 'file is created$'
	msg3 db 0dh, 0ah, 'error in file creation$'
	msg4 db 0dh, 0ah, 'enter a text:$'
	msg5 db 0dh, 0ah, 'error in file opening$'
	msg6 db 0dh, 0ah, 'error in writing$'
	msg7 db 0dh, 0ah, 'creating and writing successful$'
	fname db 80 
		  db ?
		  db 80 dup(0)
	text db 80
		 db ? 
		 db 80 dup(?)
.code
start: 
	mov ax, @data
	mov ds, ax
	mov es, ax
	print msg1
	read fname ; reading a file name
	lea si, fname+2
	mov cl, fname+1 ; getting the length of file name
	mov ch, 00
	add si, cx
	mov byte ptr[si], 00 ; terminating file name by zero
	lea dx, fname+2
	mov ah, 3ch ; function code to create file
	mov cx, 0000h ; file attributes of the new file
	int 21h
	jnc succ1 ; if file creation is success cy=0
	print msg3
	jmp exit

	succ1: print msg2
	print msg4
	read text ; reading text to be written to file
	mov ah, 3dh ; function code to open file
	mov al, 02h ; to open file in read/write mode
	lea dx, fname+2
	int 21h
	jnc succ2 ; if file open is success cy=0
	print msg5
	jmp exit

	succ2: mov bx, ax  ; file handling returned during open
	mov ah, 40h  ; function code to write text
	mov ch, 00h  ; number of characters to written into the file
	mov cl, text+1
	lea dx, text+2
	int 21h
	jnc succ3 ; if file writing is success cy=0
	print msg6
	mov ah, 3eh ; function code to close the file
	int 21h
	jmp exit
	
	succ3: print msg7
	exit: mov ah, 4ch
	int 21h
end start