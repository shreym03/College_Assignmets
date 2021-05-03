#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

int main() {
  int pid;
  // fork a child process
  pid = fork();
  if (pid < 0) {
    // error occurred
    fprintf(stderr, "Fork Failed");
    return 1;
  }
  else if (pid == 0) {
    // child process
    execlp("/bin/ls", "ls", NULL);
    printf("LINE J"); // control returns here only in case of error
    exit();
  }
  else {
    /*
    * parent process
    * parent will wait for the child to complete
    */
    wait(NULL);
    printf("Child Complete");
  }
  return 0;
}
// void execlp(char *program, char *arg0,...,char *argn, NULL); searches the directories in the PATH environment variable for the program.