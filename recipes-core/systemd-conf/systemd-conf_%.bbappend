FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_imx8mp-imdt-picoevk = " \
    file://25-wlan.network \
"

FILES_${PN}_imx8mp-imdt-picoevk += " \
    ${sysconfdir}/systemd/network/25-wlan.network \
"

do_install_append_imx8mp-imdt-picoevk() {
    install -d ${D}${sysconfdir}/systemd/network
    install -m 0644 ${WORKDIR}/25-wlan.network ${D}${sysconfdir}/systemd/network
}