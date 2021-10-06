FILESEXTRAPATHS_append_imx8mp-imdt-picoevk := "${THISDIR}/${PN}:"

SRC_URI_append_imx8mp-imdt-picoevk = " file://sensor.conf "

do_install_append_imx8mp-imdt-picoevk() {
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/sensor.conf ${D}${sysconfdir}/modprobe.d
}

FILES_${PN}_append_imx8mp-imdt-picoevk = " ${sysconfdir}/modprobe.d"
