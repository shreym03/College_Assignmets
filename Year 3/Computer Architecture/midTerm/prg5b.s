# Program 5 b 
#Write a MALP to find GCD using recursive method
.data
	msg_a: .asciiz "Enter a:"
	msg_b: .asciiz "Enter b:"
	msg_result: .asciiz "The Greatest Common Divisor is "
.text
.globl main
	
main:
	li $v0,4
	la $a0, msg_a
	syscall
	li $v0,5
	syscall
	move $t0,$v0 				#t0=a

	li $v0,4
	la $a0, msg_b
	syscall
	li $v0,5
	syscall
	move $t1,$v0 				#t1=b

	move $a0,$t0 				#a0=a
	move $a1,$t1 				#a1=b
	jal gcd

	move $t0,$v0 				#Moves gcd to t0 temporarily
	li $v0,4
	la $a0,msg_result
	syscall
	
	li $v0,1
	move $a0,$t0
	syscall
	
	li $v0,10
	syscall
.end main

gcd:
	addi $sp, $sp, -4 			#Acts like a counter, I think
	sw $ra,0($sp)

	bne $a0, $a1, less_than
	move $v0, $a0
	jr $ra

less_than:	
	bgt $a0,$a1, great_than
	sub $a1,$a1,$a0 			# b=b-a
	j continue

great_than:
	sub $a0,$a0,$a1 			# a=a-b

continue:
	jal gcd
	#addi $sp,$sp,4  			#This would also work in this case (instead of writing AFTER lw)
	lw $ra,0($sp)
	addi $sp, $sp, 4
	jr $ra

