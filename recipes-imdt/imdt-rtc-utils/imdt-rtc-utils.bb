SUMMARY = "Sample RTC User-Space Application"
LICENSE = "CLOSED"


SRC_URI = "file://rtc-get-time.c"

S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} ${LDFLAGS} -o rtc-get-time rtc-get-time.c
}

do_install() {
    install -d ${D}/opt/imdt/rtc
    install -m 0755 rtc-get-time ${D}/opt/imdt/rtc
}

FILES_${PN} += " /opt/imdt/rtc/"
