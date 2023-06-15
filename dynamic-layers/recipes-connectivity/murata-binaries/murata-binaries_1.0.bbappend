FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI_append_imdt-pico = " \
    file://add_wlan.patch;patchdir=${WORKDIR}/nxp-linux-calibration \
"
do_install_append_imdt-pico-e () {
        install -m 644 ${WORKDIR}/nxp-linux-calibration/murata/files/wifi_mod_para_murata.conf ${D}/lib/firmware/nxp/wifi_mod_para.conf
}


