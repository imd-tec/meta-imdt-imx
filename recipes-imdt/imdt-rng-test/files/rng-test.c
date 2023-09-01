#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

#define RANDOM_BYTES 32  // Number of random bytes to read

int main() {
    int fd = open("/dev/hwrng", O_RDONLY);
    if (fd < 0) {
        perror("Failed to open /dev/hwrng");
        return 1;
    }

    unsigned char random_data[RANDOM_BYTES];
    ssize_t bytes_read = read(fd, random_data, sizeof(random_data));
    if (bytes_read < 0) {
        perror("Failed to read random data");
        close(fd);
        return 1;
    }

    printf("Random Data:");
    for (ssize_t i = 0; i < bytes_read; ++i) {
        printf(" %02x", random_data[i]);
    }
    printf("\n");

    close(fd);
    return 0;
}
