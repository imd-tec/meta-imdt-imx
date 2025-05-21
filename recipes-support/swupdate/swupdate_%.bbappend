#
# Copyright (c) 2022 IMD Technologies
#

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://defconfig \
"
do_install:append() {
    echo "${MACHINE} 1.0" > ${D}/${sysconfdir}/hwrevision
}
