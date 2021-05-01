# Program 5 a 
# Write a MALP to find GCD using non-recursive

.data
	msg_a: .asciiz "Enter the value of a:"
	msg_b: .asciiz "Enter the value of b:"
	msg_result: .asciiz "The greatest common divisor is "
.text
.globl main
	
main: 
	li $v0, 4
	la $a0, msg_a
	syscall
	li $v0, 5
	syscall
	move $t0, $v0 #t0=a

	li $v0, 4
	la $a0, msg_b
	syscall
	li $v0, 5
	syscall
	move $t1, $v0 #t1=b


while_loop:
	beq $t0, $t1,exit
	
	bgt $t0, $t1,if_state
	sub $t1, $t1,$t0 #b=b-a
	j while_loop

if_state:
	sub $t0,$t0,$t1 #a=a-b

exit:
	li $v0, 4
	la $a0, msg_result
	syscall
	
	li $v0, 1
	move $a0, $t0
	syscall
	
	li $v0, 10
	syscall
.end main
