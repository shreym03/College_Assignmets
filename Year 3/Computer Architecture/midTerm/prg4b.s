#Program 4 ii
# Write a MAPLP to binary search for no in a array

.data
A:      .word   -32, -16, 0, 8, 16, 32,64
n:      .word   7
data:   .word -16
msg_true:   .asciiz "Found at position: "
msg_false:   .asciiz "Not Found"

.text
.globl main

main:
        lw $t0, data
        li $t1, 0   #0 means isFound variable. 0 means not found
        li $t2, 0  #t2 is start number
        lw $t3, n
        addi $t3, $t3, -1 #t3 is end number


lmain:
        bgt $t2, $t3, end_loop

        add  $t4, $t2, $t3 #t4 is mid, therefore we add start and stop to mid
        srl  $t4, $t4,  1 #Same as divide by 2

        sll $t5, $t4, 2 #Each word is 4 bits and we need to print from 4*mid bit
        lw $t6, A($t5) #t6 is A[mid]
        bne $t0, $t6, great_than #If not equal, means that we go to changing start/end
        li $t1, 1 # means it is found
        j end_loop

great_than:
        blt $t0, $t6, less_than #(data<A[mid])
        addi $t2, $t4, 1 #low = mid+1
        j lmain
less_than:
        addi $t3, $t4, -1 #high = mid -1
        j lmain

end_loop:
        li $v0, 1
        move $a0, $t0
        syscall
        li $v0, 4
        beq $t1, $zero, msg_nf
        
        la $a0, msg_true
        syscall
        li $v0, 1
        move $a0, $t4
        syscall
        j exit

msg_nf:
        la $a0, msg_false
        syscall

exit:
        li $v0, 10
        syscall
.end main
