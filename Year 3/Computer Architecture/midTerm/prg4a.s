#Program 2
# Write MALP to check if a given no is an Armstrong number

.data

msg_input: .asciiz "Enter the number:"
msg_true: .asciiz "It is an Armstrong number"
msg_false: .asciiz "It is not an Armstrong number"
num: .word 0

.text
.globl main

main: 

	li $v0, 4
	la $a0, msg_input
	syscall

	li $v0, 5
	syscall
	sw $v0, num

	lw $t0, num #To calculate
	lw $s0, num #To compare

loop: 
	beq $t0, $zero, next
	li $t1, 10
	div $t0, $t1
	mfhi $t2 # digit (t2) = num % 10

	mul $t3, $t2, $t2
	mul $t4, $t3, $t2
	add $t5, $t5, $t4

	div $t0, $t1
	mflo $t0 #num =num/10
	j loop
next:
	bne $s0, $t7, else
	li $v0, 4
	la $a0, msg_true
	j exit
else:
	li $v0, 4
	la $a0, msg_false
	syscall
exit:
	li $v0, 10
	syscall 
.end main

