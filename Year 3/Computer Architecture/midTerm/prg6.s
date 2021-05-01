#Program 6
# Write a MALP to concatinate two string

.data
	msg_bfr: .asciiz " Before Concatination:"
	msg_aftr: .asciiz " After Concatination:"
	des: .asciiz "abc"
	filler: .space 8      		#making space for des after concatination (8 is just a random number)
	src: .asciiz "xyz"
	
.text
.globl main
main:
	li $v0,4
	la $a0,msg_bfr
	syscall
	
	la $a0,des
	syscall

	li $v0,11 					#New Line (print single charater)
	la $a0,13
	syscall

	la $t0,des               	# t0=address of des
	lb $t1,0($t0)            	# t1=ascii value of first byte in the string (ie 0x61{a} in binary of course)
 L1:   
	beq $t1, $zero, des_over	#check for end line charcter 00 (not "00" actual 00)
	addi $t0,$t0,1   			#Address incremented by 1
	lb $t1,0($t0)		 		#Loading next charcter (ie 0x62{b} ) and so on
	j L1
			 
des_over:						# after this loop, t1 will point to address of the end line charcter of des
	la $t2,src					# t2=address of src
	lb $t4,0($t2)		 		#loads first character of src (ie 0x78 {x}) 
L2:
	beq $t4,$zero,src_over
	sb $t4,0($t0)		 		#concatination des
	addi $t0,$t0,1		 		#next address for des	
	addi $t2,$t2,1		 		#next address for src
	lb $t4,0($t2)		 		#Loading next charcter (ie 0x79{y} ) and so on
	j L2
src_over:
	sb $zero,0($t0) 	 		#adds new end of line character for des
	li $v0,4
	la $a0,msg_aftr
	syscall
	
	la $a0,des
	syscall
	
	li $v0,10
	syscall
.end main

