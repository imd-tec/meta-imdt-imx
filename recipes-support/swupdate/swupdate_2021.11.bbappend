#
# Copyright (c) 2022 IMD Technologies
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Rebrand-the-SWUpdate-UI.patch \
    file://defconfig \
"
do_install_append_imdt-pico-em() {
    echo "pico-em 1.0" > ${D}/${sysconfdir}/hwrevision
}

do_install_append_imdt-pico-e() {
    echo "pico-e 1.0" > ${D}/${sysconfdir}/hwrevision
}

do_install_append_imdt-pico-v2() {
    echo "pico 2.0" > ${D}/${sysconfdir}/hwrevision
}

do_install_append_imdt-pico-v3() {
    echo "pico 3.0" > ${D}/${sysconfdir}/hwrevision
}

do_install_append_imdt-pico-v3-0004() {
    echo "pico 3.0-0004" > ${D}/${sysconfdir}/hwrevision
}

do_install_append_imdt-pico-v3-0005() {
    echo "pico 3.0-0005" > ${D}/${sysconfdir}/hwrevision
}

FILES_${PN}_append_imdt-pico-em = " \
    ${sysconfdir}/hwrevision \
"

FILES_${PN}_append_imdt-pico-e = " \
    ${sysconfdir}/hwrevision \
"

FILES_${PN}_append_imdt-pico-v2 = " \
    ${sysconfdir}/hwrevision \
"

FILES_${PN}_append_imdt-pico-v3 = " \
    ${sysconfdir}/hwrevision \
"

FILES_${PN}_append_imdt-pico-v3-0004 = " \
    ${sysconfdir}/hwrevision \
"

FILES_${PN}_append_imdt-pico-v3-0005 = " \
    ${sysconfdir}/hwrevision \
"
