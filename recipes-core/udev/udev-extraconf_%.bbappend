#
# Copyright (c) 2022 IMD Technologies
#

# picoevk

FILESEXTRAPATHS_append_imdt-pico := "${THISDIR}/${PN}:"

SRC_URI_append_imdt-pico = " \
    file://ap1302-sensor-pico-v2.conf \
    file://nxp_depmod.conf \
    file://nxp_modules.conf \
"

do_install_append_imdt-pico() {
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/ap1302-sensor-pico-v2.conf ${D}${sysconfdir}/modprobe.d
}

FILES_${PN}_append_imdt-pico = " ${sysconfdir}/modprobe.d"

do_install_append_imdt-pico-e() {
    # install murata 1xk module startup for pico-e
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/nxp_modules.conf ${D}${sysconfdir}/modprobe.d

    install -d ${D}${sysconfdir}/depmod.d
    install -m 0644 ${WORKDIR}/nxp_depmod.conf ${D}${sysconfdir}/depmod.d
}

FILES_${PN}_append_imdt-pico-e = " ${sysconfdir}/modprobe.d ${sysconfdir}/depmod.d"

# uevk

FILESEXTRAPATHS_append_imdt-uevk := "${THISDIR}/${PN}:"

SRC_URI_append_imdt-uevk = " file://ap1302-sensor-uevk.conf "

do_install_append_imdt-uevk() {
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/ap1302-sensor-uevk.conf ${D}${sysconfdir}/modprobe.d
}

FILES_${PN}_append_imdt-uevk = " ${sysconfdir}/modprobe.d"
