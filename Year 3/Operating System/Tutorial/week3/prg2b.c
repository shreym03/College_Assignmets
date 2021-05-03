// Copy contents of one file to another file
#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <fcntl.h>
#include <string.h>

int main(int argc, char const* argv[]) {
	int feed1, feed2;
	char b[10], wb[10];

	feed1 == open(argv[1], O_RDONLY);
	if (feed1 == -1) {
		printf("File open error\n");
		return 1;
	}
	else
		printf("File succesfully open for writing\n");

	while (read(feed1, b, sizeof(b)) != 0)
		write(feed2, b, (strlen(b) - 1));
	return 0;
}
