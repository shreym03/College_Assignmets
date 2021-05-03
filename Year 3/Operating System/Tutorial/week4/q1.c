// C Program to illustrate fork() system call
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <stdlib.h>
#include <sys/wait.h>

int main() {
	int pid, status;
	pid = fork();
	if (pid < 0) {
		printf("Error in fork\n");
		return 1;
	}
	else if (pid == 0) {
		printf("In Child process\n");
		printf("\n\nPid of the child is %d\n", getpid());
		printf("Pid of the parent is %d\n", getppid());
		sleep(5);
		exit(3);
	}
	else {
		printf("\n\nIn parent\n");
		printf("The child pid is %d\n", pid);
		printf("Mypid id %d\n", getpid());
		int a = waitpid(-1, &status, 0);
		printf("The process with the pid %d has terminated with the status %d\n", a, WEXITSTATUS(status));
	}
}
