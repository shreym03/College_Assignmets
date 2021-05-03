// Program to make a child process execute a C program
#include<stdio.h>
#include<unistd.h>
#include<sys/types.h>
#include<stdlib.h>

main() {
  if (fork() == 0) {
    execlp("./pg.o", "./pg.o", 0);
    printf("Error\n");/*control returns here only in case of error */
    exit(1);
  }
  else {
    wait(0);
    printf("Parent\n");
  }
}