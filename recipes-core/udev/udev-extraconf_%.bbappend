# picoevk

FILESEXTRAPATHS_append_imx8mp-imdt-picoevk := "${THISDIR}/${PN}:"

SRC_URI_append_imx8mp-imdt-picoevk = " file://ap1302-sensor-picoevk.conf "

do_install_append_imx8mp-imdt-picoevk() {
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/ap1302-sensor-picoevk.conf ${D}${sysconfdir}/modprobe.d
}

FILES_${PN}_append_imx8mp-imdt-picoevk = " ${sysconfdir}/modprobe.d"

# uevk

FILESEXTRAPATHS_append_imx8mp-imdt-uevk := "${THISDIR}/${PN}:"

SRC_URI_append_imx8mp-imdt-uevk = " file://ap1302-sensor-uevk.conf "

do_install_append_imx8mp-imdt-uevk() {
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/ap1302-sensor-uevk.conf ${D}${sysconfdir}/modprobe.d
}

FILES_${PN}_append_imx8mp-imdt-uevk = " ${sysconfdir}/modprobe.d"

# uevk-2g

FILESEXTRAPATHS_append_imx8mp-imdt-uevk-2g := "${THISDIR}/${PN}:"

SRC_URI_append_imx8mp-imdt-uevk-2g = " file://ap1302-sensor-uevk.conf "

do_install_append_imx8mp-imdt-uevk-2g() {
    install -d ${D}${sysconfdir}/modprobe.d
    install -m 0644 ${WORKDIR}/ap1302-sensor-uevk.conf ${D}${sysconfdir}/modprobe.d
}

FILES_${PN}_append_imx8mp-imdt-uevk-2g = " ${sysconfdir}/modprobe.d"
