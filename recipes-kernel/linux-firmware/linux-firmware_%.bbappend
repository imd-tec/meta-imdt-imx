#
# Copyright (c) 2025 IMD Technologies
#

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI:append = " \
    file://ap1302_ar1335_single_fw.bin \
    file://ap1302_ar0521_single_fw_2lane.bin \
"


do_install:append() {
    # AP1302 ISP firmware
    install -m 0644 ${WORKDIR}/ap1302_ar1335_single_fw.bin ${D}${nonarch_base_libdir}/firmware/ap1302_ar1335_single_fw.bin
    install -m 0644 ${WORKDIR}/ap1302_ar0521_single_fw_2lane.bin ${D}${nonarch_base_libdir}/firmware/ap1302_ar0521_single_fw.bin # Strip the lane suffix as the driver does not use it
}

PACKAGES =+ "${PN}-ap1302"

FILES:${PN}-ap1302 = " \
    ${nonarch_base_libdir}/firmware/ap1302_ar1335_single_fw.bin \
    ${nonarch_base_libdir}/firmware/ap1302_ar0521_single_fw.bin \
"
