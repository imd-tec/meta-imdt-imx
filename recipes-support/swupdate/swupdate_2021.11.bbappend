#
# Copyright (c) 2022 IMD Technologies
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Rebrand-the-SWUpdate-UI.patch \
    file://defconfig \
"

do_install_append_imdt-pico-v2() {
    echo "/dev/mmcblk1 0x400000 0x4000" > ${D}/${sysconfdir}/fw_env.config
    echo "pico 2.0" > ${D}/${sysconfdir}/hwrevision
}

FILES_${PN}_append_imdt-pico-v2 = " \
    ${sysconfdir}/fw_env.config \
    ${sysconfdir}/hwrevision \
"
