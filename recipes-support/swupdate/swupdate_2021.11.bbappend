#
# Copyright (c) 2022 IMD Technologies
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Rebrand-the-SWUpdate-UI.patch \
    file://defconfig \
"

do_install_append_imdt-pico-v2() {
    echo "pico 2.0" > ${D}/${sysconfdir}/hwrevision
}

do_install_append_imdt-pico-v3() {
    echo "pico 3.0" > ${D}/${sysconfdir}/hwrevision
}

FILES_${PN}_append_imdt-pico-v2 = " \
    ${sysconfdir}/hwrevision \
"

FILES_${PN}_append_imdt-pico-v3 = " \
    ${sysconfdir}/hwrevision \
"
