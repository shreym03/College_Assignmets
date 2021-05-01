; Write a program to complete binary search in an array
.data
A:      .word   -32, -16, 0, 8, 16, 32,64
n:      .word   7
data:   .word -16
msg1:   .asciiz "Found at position: "
msg2:   .asciiz "Not Found"

.text
.globl main

main:
	lw $t0, data
	li $t1, 0							; 0 means isFound variable. 0 means not found
	li $t2, 0							; t2 is begining number
	lw $t3, n
	sub $t3, $t3, 1						; t3 is end number

lmain:
	bgt $t2 ,$t3 , end_loop
	add  $t4, $t2, $t3
	srl  $t4,$t4, 1 					; Same as divide by 2
	sllv $t5, $t4, 2 					; Each word is 4 bits and we need to print from 4*mid bit
	lw $t6, A($t5) #t6 is A[mid]
	bne $t0, $t6, not_eq
	li $t1,1 							; means it is found
	j end_loop
not_eq:
	blt $t0,$t6,less_than #(data<A[mid])
	addiu $t2, $t4, 1 #low = mid+1
	j lmain
less_than:
	addiu $t3, $t4, -1
	j lmain
end_loop:
	li $v0,1
	move $a0,$t0
	syscall
	li $v0,4
	beq $t1, $zero, msg_nf
	la $a0,msg1
	syscall
	li $v0,1
	move $a0,$t4
	syscall
	j exit
msg_nf:
	la $a0,msg2
	syscall
exit:
	li $v0,10
	syscall	
