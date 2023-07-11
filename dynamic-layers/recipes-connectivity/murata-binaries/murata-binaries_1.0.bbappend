inherit systemd
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "mlanconf.service"

FILES_${PN} += "${systemd_unitdir}/system/mlanconf.service"

SRC_URI_append_imdt-pico = " \
    file://add_wlan.patch;patchdir=${WORKDIR}/nxp-linux-calibration \
    file://switch_regions.patch;patchdir=${WORKDIR}/nxp-linux-calibration \
    file://mlanconf.service \
"
do_install_append_imdt-pico-e () {
        # remove switch_modules script as we do not support this feature
        rm -f ${D}/usr/sbin/switch_module.sh
        install -m 644 ${WORKDIR}/nxp-linux-calibration/murata/files/wifi_mod_para_murata.conf ${D}/lib/firmware/nxp/wifi_mod_para.conf

        install -d ${D}/${systemd_unitdir}/system
        install -m 0644 ${WORKDIR}/mlanconf.service ${D}/${systemd_unitdir}/system
}
