# Copyright (c) 2021 IMD Technologies

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_imx8mp-imdt-picoevk = "file://ap1302_ar1335_single_fw.bin"
SRC_URI_append_imx8mp-imdt-uevk = "file://ap1302_ar1335_single_fw.bin"
SRC_URI_append_imx8mp-imdt-uevk-2g = "file://ap1302_ar1335_single_fw.bin"

do_install_append_imx8mp-imdt-picoevk() {

    # AP1302 ISP firmware
    install -m 0644 ${WORKDIR}/ap1302_ar1335_single_fw.bin ${D}/lib/firmware/ap1302_ar1335_single_fw.bin

    # Murata 1DX NVRAM file
    cp ${D}/lib/firmware/brcm/brcmfmac43430-sdio.MUR1DX.txt ${D}${nonarch_base_libdir}/firmware/brcm/brcmfmac43430-sdio.imdt,imx8mp-imdt-picoevk.txt
}

do_install_append_imx8mp-imdt-uevk() {

    # AP1302 ISP firmware
    install -m 0644 ${WORKDIR}/ap1302_ar1335_single_fw.bin ${D}/lib/firmware/ap1302_ar1335_single_fw.bin
}

do_install_append_imx8mp-imdt-uevk-2g() {

    # AP1302 ISP firmware
    install -m 0644 ${WORKDIR}/ap1302_ar1335_single_fw.bin ${D}/lib/firmware/ap1302_ar1335_single_fw.bin
}
