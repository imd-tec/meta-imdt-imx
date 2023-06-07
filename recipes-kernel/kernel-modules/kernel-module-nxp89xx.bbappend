
FILESEXTRAPATHS_append_imdt-pico := "${THISDIR}/${PN}:"

SRC_URI_append_imdt-pico = " \
    file://moal-opt.conf \
    file://moal.conf \
"

do_install_append_imdt-pico() {

    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/moal-opt.conf ${D}${sysconfdir}/modprobe.d

    # Install systemd related configuration file
    install -d ${D}${sysconfdir}/modules-load.d
    install -m 0644 ${WORKDIR}/moal.conf ${D}${sysconfdir}/modules-load.d
}

FILES_${PN}_append_imdt-pico = " ${sysconfdir}/modprobe.d ${sysconfdir}/modules-load.d"

