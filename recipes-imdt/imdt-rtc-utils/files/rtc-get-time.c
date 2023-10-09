#include <stdio.h>
#include <fcntl.h>
#include <sys/ioctl.h>
#include <linux/rtc.h>
#include <unistd.h>

int main() {
    int rtc_fd = open("/dev/rtc0", O_RDONLY);
    if (rtc_fd < 0) {
        perror("Failed to open RTC device");
        return 1;
    }

    struct rtc_time rtc_tm;
    if (ioctl(rtc_fd, RTC_RD_TIME, &rtc_tm) == -1) {
        perror("Failed to read RTC time");
        close(rtc_fd);
        return 1;
    }

    printf("Current RTC time: %02d:%02d:%02d\n", rtc_tm.tm_hour, rtc_tm.tm_min, rtc_tm.tm_sec);

    close(rtc_fd);
    return 0;
}
