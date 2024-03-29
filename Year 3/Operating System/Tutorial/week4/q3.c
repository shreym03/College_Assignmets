#include <sys/types.h>
#include <stdio.h>
#include <unistd.h>

int value = 5;

int main() {
  int pid;

  pid = fork();
  if (pid == 0) {
    value += 15;
    printf("CHILD: value = %d\n", value); // LINE A
    return 0;
  }
  else if (pid > 0) {
    wait(NULL);
    printf("PARENT: value = %d", value); // LINE B
    return 0;
  }
}