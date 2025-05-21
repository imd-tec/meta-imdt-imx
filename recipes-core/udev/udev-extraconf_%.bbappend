#
# Copyright (c) 2022 IMD Technologies
#

FILESEXTRAPATHS:append := "${THISDIR}/${PN}:"

SRC_URI:append = " \
    file://ap1302-sensor-pico-v2.conf \
    file://nxp_depmod.conf \
    file://nxp_modules.conf \
"

do_install:append() {
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/ap1302-sensor-pico-v2.conf ${D}${sysconfdir}/modprobe.d
}

FILES:${PN}:append = " ${sysconfdir}/modprobe.d"

do_install:append() {
    # install murata 1xk module startup for pico
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/nxp_modules.conf ${D}${sysconfdir}/modprobe.d

    install -d ${D}${sysconfdir}/depmod.d
    install -m 0644 ${WORKDIR}/nxp_depmod.conf ${D}${sysconfdir}/depmod.d
}

FILES:${PN}:append = " ${sysconfdir}/modprobe.d ${sysconfdir}/depmod.d"


