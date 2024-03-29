;#Write a program to find exponential of a
.data
a:    .word 9
n:    .word 5
pow:  .word 0


	.text
	.globl main
main:
	lw   $a0, a 
	lw   $a1, n
	jal  power
	sw   $v0, pow

	li   $v0, 1
	lw   $a0, pow
	syscall

	li   $v0, 10 #END
	syscall

power:
	addi $sp, $sp, -8     ; adjust stack for 2 items
	sw   $ra, 4($sp)      ; save return address
	sw   $a0, 0($sp) 
	addi $t1, $zero, 1    ; $t1 = 1
	bgt  $a1, $t1, L1     ; if $a1(=n) > $t1(=1) goto L1
	move $v0, $a0         ; if $a1(=n) == $t1(=1), result is $a0(=n)
	addi $sp, $sp,  8     ; pop 2 items from stack
	jr   $ra              ; and return
L1: 
	addi $a1, $a1, -1     ; decrement n
	jal  power            ; recursive call: $v0=power(a, n-1)
	lw   $a0, 0($sp)      ; restore original a
	mul  $v0, $a0, $v0    ; pseudo inst: multiply $v0=$a0(=a)*$v0(=power(a,n-1))

	lw   $ra, 4($sp)      ; retrive return address
	addi $sp, $sp, 8      ; restore sp
	jr   $ra              ; and return
