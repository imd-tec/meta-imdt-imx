SUMMARY = "Random Number Generator Application"
LICENSE = "CLOSED"

SRC_URI = " \
    file://rng-test.c \
    file://rng-test.sh \
"
S = "${WORKDIR}"

do_compile() {
    ${CC} ${CFLAGS} -o random-generator rng-test.c ${LDFLAGS}
}

do_install() {
    install -d ${D}/opt/imdt/rng
    install -m 0755 random-generator ${D}/opt/imdt/rng
    install -m 0755 rng-test.sh ${D}/opt/imdt/rng
}

FILES_${PN} += " /opt/imdt/rng/"

RDEPENDS_${PN} += "bash"
