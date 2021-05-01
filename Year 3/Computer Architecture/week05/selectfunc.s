; program to emulate a calculator
.data
x: .word 10
y: .word 6
z: .word 0
op: .word 2 ; Add is 0, sub is 1, etc.
plus_str: .asciiz " PLUS "
minus_str: .asciiz " MINUS "
mul_str: .asciiz " INTO "
div_str: .asciiz " BY "
mod_str: .asciiz " MOD "
equ_str: .asciiz " = "

ftprs: .word f_add, f_sub, f_mul, f_div, f_mod

op_str: .word plus_str, minus_str, mul_str, div_str, mod_str

.text
.globl main

main:
	lw $a0, x
	lw $a1, y
	lw $a2, op
	jal do_op
	sw $v0, z

	li $v0, 1
	lw $a0, x
	syscall

	li $v0, 4
	lw $t0, op
	sll $t0, $t0, 2
	lw $a0, op_str($t0)
	syscall

	li $v0, 1
	lw $a0, y
	syscall

	li $v0, 4
	la $a0, equ_str
	syscall

	li $v0, 1
	lw $a0, z
	syscall

	li $v0,10
	syscall
do_op:
	addi $sp, $sp, -4
	sw $ra, 0($sp)

	sll $t0, $a2, 2
	lw $t1, ftprs($t0)
	jalr $t1
	lw $ra, 0($sp)
	addi $sp, $sp, 4
	jr $ra

f_add:
	add $v0, $a0, $a1
	jr $ra

f_sub:
	sub $v0, $a0, $a1
	jr $ra

f_mul:
	mul $v0, $a0, $a1
	jr $ra

f_div:
	div $v0, $a0, $a1
	jr $ra

f_mod:
	rem $v0, $a0, $a1
	jr $ra
