.data
msg_enter: .asciiz "Enter the year"
msg_true: .asciiz "It is a leap year"
msg_false: .asciiz "It is not a leap year"
year: .word 0
.text
.globl main

main:

	
	li $v0, 4 
	la $a0, msg_enter
	syscall
	li $v0, 5
	syscall
	sw $v0, year

	lw $t0, year ;(Year% 4 == 0)?
	li $t1,4
	rem $t2,$t0,$t1
	bne $t2, $zero, false

	li $t1, 100 ; and (Year % 100 != 0)?
	rem $t2,$t0,$t1
	bne $t2, $zero, true

	li $t1, 400 ; or (Year % 400 == 0)?
	rem $t2,$t0,$t1
	bne $t2, $zero, false

true:
	li $v0, 4 
	la $a0,msg_true
	syscall
	j exit

false:
	li $v0, 4
	la $a0, msg_false
	syscall

exit:
	li $v0,10
	syscall

