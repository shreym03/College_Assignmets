; Program to find sum from 1 to N 
.data
msg1:	.asciiz "Enter N:"
msg2:	.asciiz "The sum is"
no:		.word 0
sum:	.word 0
crlf:	.byte 0xd, 0xa, 0

.text
.globl main

main:
	li $v0, 4
	la $a0, msg1
	syscall

	li $v0, 5
	syscall
	sw $v0, no

	li $t0, 0
	li $t1,1
	lw $t2, no

next:
	bgt $t1,$t2,over
	add $t0, $t0, $t1
	addi $t1, $t1, 1
	j next

over:
	sw $t0, sum

	li $v0, 1
	lw $a0, sum
	syscall

	li $v0, 4
	la $a0, crlf
	syscall

	li $v0, 10
	syscall
.end main
