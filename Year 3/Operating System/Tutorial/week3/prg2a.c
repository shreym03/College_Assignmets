#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
// a. Program to write some contents to a file.
#include <fcntl.h>
#include <string.h>

int main(int argc, char const* argv[]) {
	int feed;
	char wb[10];

	feed = open(argv[1], O_RDWR);
	if (feed == -1) {
		printf("File open error\n");
		return 1;
	}
	else
		printf("File open succesfully for writing\n");

	printf("Enter contents to append\n");
	gets(wb);
	printf("%s\n", wb);
	close(feed);
	return 0;
}
