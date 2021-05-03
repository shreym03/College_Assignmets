// write into a file after a specified number of bytes using lseek system call
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>

int main(int argc, char const* argv[]) {
	int feed;

	feed == open(argv[1], O_RDONLY);
	if (feed == -1) {
		printf("File open error\n");
		return 1;
	}
	else
		printf("File opened successfully\n");

	lseek(feed, 10, SEEK_SET);
	write(feed, "HELLOWORLD", 10);
	close(feed);
	return 0;
}
