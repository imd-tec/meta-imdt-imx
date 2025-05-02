#
# Copyright (c) 2022 IMD Technologies
#

FILESEXTRAPATHS_append := "${THISDIR}/${PN}:"

SRC_URI_append = " \
    file://ap1302-sensor-pico-v2.conf \
    file://nxp_depmod.conf \
    file://nxp_modules.conf \
"

do_install_append() {
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/ap1302-sensor-pico-v2.conf ${D}${sysconfdir}/modprobe.d
}

FILES_${PN}_append = " ${sysconfdir}/modprobe.d"

do_install_append() {
    # install murata 1xk module startup for pico
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/nxp_modules.conf ${D}${sysconfdir}/modprobe.d

    install -d ${D}${sysconfdir}/depmod.d
    install -m 0644 ${WORKDIR}/nxp_depmod.conf ${D}${sysconfdir}/depmod.d
}

FILES_${PN}_append = " ${sysconfdir}/modprobe.d ${sysconfdir}/depmod.d"


