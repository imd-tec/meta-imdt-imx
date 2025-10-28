#
# Copyright (c) 2022 IMD Technologies
#

FILESEXTRAPATHS:prepend := "${THISDIR}/${PN}:"

SRC_URI += " \
    file://0001-Rebrand-the-SWUpdate-UI.patch \
    file://defconfig \
"
do_install:append() {
    echo "${MACHINE} 1.0" > ${D}/${sysconfdir}/hwrevision
}
# Ensure imdt-swupdate-doctor is installed alongside swupdate so that the upgrade_available flag is cleared on successful updates
RDEPENDS:${PN}:append = " imdt-swupdate-doctor" 