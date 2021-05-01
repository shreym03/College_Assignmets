; Convert word to float
.data
num:	.word	42
fnum:	.float	0.0
.text
.globl main
main:
	lw $t0, inum
	mtc1 $t0, $f6
	cvt.s.w $f12, $f6
	s.s $f12, fnum
	li $v0, 2
	syscall
	li $v0, 10
	syscall
