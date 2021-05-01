.data 
a: .word 20
bb: .word 40
c: .word 60
d: .word 80
e: .word 100
msg_result: .asciiz "The final result is "

.text
.globl main

main:
	lw $s0, a
	lw $s1, bb
	lw $s2, c
	lw $s3, d
	lw $s4, e

	mul $t0,$s0,$s1

	#div $t0, $s2
	#mflo $t1
	div $t1,$t0	,$s2

	#div $t1, $s3
	#mfhi $t2
	rem $t2,$t1,$s3

	add $s5, $t2, $s4

	li $v0,4
	la $a0,msg_result
	syscall
	li $v0, 1
	move $a0,$s5
	syscall

	li $v0,10
	syscall

