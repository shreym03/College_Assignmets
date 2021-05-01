; program to check if number is prime
.data
msg1:		.asciiz "Enter No: "
msg_p:	.asciiz "The number is prime\n"
msg_np:	.asciiz "The number is not prime\n"
num:		.word 0

.text
.globl main

main: 
	li $v0, 4
	la $a0, msg1
	syscall

	li $v0, 5
	syscall
	sw $v0, num

	lw $t0, num
	srlv $t1, $t0, 1
	li $t2, 1
	li $t3, 2

next_i:
	bleu $t3,$t1,calc_rem
	j check_prime
	
calc_rem:
	divu $t0, $t3
	mfhi $t4
	bne $t4, $0, try_next
	li $t2, 0
	j check_prime

try_next:
	addiu $t3, $t3, 1
	j next_i

check_prime:
	beq $t2, $0, not_prime
	la $a0, msg_p
	j print_msg

not_prime:
	la $a0,msg_np

print_msg:
	li $v0, 4
	syscall

	li $v0, 10
	syscall
