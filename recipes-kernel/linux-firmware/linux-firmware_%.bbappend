#
# Copyright (c) 2022 IMD Technologies
#

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_imdt-pico-e = " \
    file://sdiouartiw416_combo_v0_16.92.21.p84.3.bin \
"

SRC_URI_append_imdt-pico = " \
    file://ap1302_ar1335_single_fw.bin \
    file://BCM4343A1_001.002.009.0153.0520.1DX.hcd \
"

SRC_URI_append_imdt-uevk = " \
    file://ap1302_ar1335_single_fw.bin.uevk \
"

do_install_append_imdt-pico-e() {
    # uninstall previous wifi conf
    rm -f ${D}${nonarch_base_libdir}/firmware/nxp/wifi_mod_para.conf
    
    # Install pico-e wifi drivers from newer imx-firmware version (6-1-36-2.1.0)
    install -d ${D}${nonarch_base_libdir}/firmware/nxp

    # Install NXP Connectivity IW416 firmware
    install -m 0644 ${WORKDIR}/sdiouartiw416_combo_v0_16.92.21.p84.3.bin ${D}${nonarch_base_libdir}/firmware/nxp/sdiouartiw416_combo_v0.bin
}

do_install_append_imdt-pico() {
    # AP1302 ISP firmware
    install -m 0644 ${WORKDIR}/ap1302_ar1335_single_fw.bin ${D}/lib/firmware/ap1302_ar1335_single_fw.bin

    # Murata 1DX NVRAM file
    cp ${D}/lib/firmware/brcm/brcmfmac43430-sdio.MUR1DX.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.imdt,${MACHINE}.txt

    # Murata 1DX Bluetooth firmware
    install -m 0644 ${WORKDIR}/BCM4343A1_001.002.009.0153.0520.1DX.hcd ${D}${sysconfdir}/firmware/BCM43430A1.1DX.hcd
}

do_install_append_imdt-uevk() {

    # AP1302 ISP firmware
    install -m 0644 ${WORKDIR}/ap1302_ar1335_single_fw.bin.uevk ${D}/lib/firmware/ap1302_ar1335_single_fw.bin
}

PACKAGES =+ "${PN}-ap1302"

FILES_${PN}-ap1302 = " \
    ${nonarch_base_libdir}/firmware/ap1302_ar1335_single_fw.bin \
"

FILES_${PN}-bcm43430_append_imdt-pico = " \
    ${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.imdt,${MACHINE}.txt \
"
