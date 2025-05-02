#
# Copyright (c) 2022 IMD Technologies
#

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Rebrand-the-SWUpdate-UI.patch \
    file://defconfig \
"
do_install_append() {
    echo "${MACHINE} 1.0" > ${D}/${sysconfdir}/hwrevision
}
