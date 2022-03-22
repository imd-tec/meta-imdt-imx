# Copyright (c) 2021 IMD Technologies

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_imx8mp-imdt-picoevk = " \
    file://ap1302_ar1335_single_fw.bin \
    file://BCM4343A1_001.002.009.0153.0520.1DX.hcd \
" 

SRC_URI_append_imx8mp-imdt-uevk = "file://ap1302_ar1335_single_fw.bin.uevk"
SRC_URI_append_imx8mp-imdt-uevk-2g = "file://ap1302_ar1335_single_fw.bin.uevk"

do_install_append_imx8mp-imdt-picoevk() {

    # AP1302 ISP firmware
    install -m 0644 ${WORKDIR}/ap1302_ar1335_single_fw.bin ${D}/lib/firmware/ap1302_ar1335_single_fw.bin

    # Murata 1DX NVRAM file
    cp ${D}/lib/firmware/brcm/brcmfmac43430-sdio.MUR1DX.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.imdt,imx8mp-imdt-picoevk.txt

    # Murata 1DX Bluetooth firmware
    install -m 0644 ${WORKDIR}/BCM4343A1_001.002.009.0153.0520.1DX.hcd ${D}${sysconfdir}/firmware/BCM43430A1.1DX.hcd
}

do_install_append_imx8mp-imdt-uevk() {

    # AP1302 ISP firmware
    install -m 0644 ${WORKDIR}/ap1302_ar1335_single_fw.bin.uevk ${D}/lib/firmware/ap1302_ar1335_single_fw.bin
}

do_install_append_imx8mp-imdt-uevk-2g() {

    # AP1302 ISP firmware
    install -m 0644 ${WORKDIR}/ap1302_ar1335_single_fw.bin.uevk ${D}/lib/firmware/ap1302_ar1335_single_fw.bin
}

PACKAGES =+ "${PN}-ap1302"

FILES_${PN}-ap1302 = " \
    ${nonarch_base_libdir}/firmware/ap1302_ar1335_single_fw.bin \
"

FILES_${PN}-bcm43430_append_imx8mp-imdt-picoevk = " \
    ${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.imdt,imx8mp-imdt-picoevk.txt \
"
