.data
	data1: 			.double 3.14
	data2: 			.double 3.14
	msg_true:		.asciiz "They are equal"
	msg_false:	.asciiz "They are not equal"
.text
.globl main
main:
	l.d $f0, data1
	l.d $f2, data2
	c.eq.d $f0, $f2
	bc1t true
	la $a0, msg_false
	j exit

true:
	la $a0, msg_true

exit:
	li $v0, 4
	syscall
	li $v0, 10
	syscall
