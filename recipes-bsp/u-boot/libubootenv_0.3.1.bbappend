#
# Copyright (c) 2022 IMD Technologies
#

do_install_append () {
    install -d ${D}/${sysconfdir}

    # TODO - change this if booting from eMMC
    echo "/dev/mmcblk1 0x400000 0x4000" > ${D}/${sysconfdir}/fw_env.config
}

FILES_${PN}_append = " \
    ${sysconfdir}/fw_env.config \
"
