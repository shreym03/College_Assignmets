/**
 * Write a C program to demonstarte syscall
 *
 * @author Shrey Mathur
 */

#include <stdio.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>
#include <errno.h>
#include <unistd.h>

int main(int argc, char const* argv[]) {
	int fd;
	char content[100] = "\0";
	fd = open(argv[1], O_RDONLY);
	if (fd < 0) {
		printf("File could not be open\n");
		perror("open");
		return 1;
	}
	else {
		read(fd, content, sizeof(content) - 1);
		write(1, content, sizeof(content) - 1);
	}
	return 0;
}
