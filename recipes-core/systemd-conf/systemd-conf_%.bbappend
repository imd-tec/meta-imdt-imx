FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append_imx8mp-imdt-picoevk = " \
    file://20-usb0.network \
    file://21-ap.network \
    file://25-wlan.network.disabled \
    file://network-gadget-init.service \
"

FILES_${PN}_append_imx8mp-imdt-picoevk = " \
    ${systemd_unitdir}/network/20-usb0.network \
    ${systemd_unitdir}/network/21-ap.network \
    ${systemd_unitdir}/network/25-wlan.network.disabled \
    ${systemd_system_unitdir}/network-gadget-init.service \
    ${systemd_system_unitdir}/multi-user.target.wants/network-gadget-init.service \
"

do_install_append_imx8mp-imdt-picoevk() {
    install -d ${D}${systemd_unitdir}/network
    install -m 0644 ${WORKDIR}/20-usb0.network ${D}${systemd_unitdir}/network

    install -d ${D}${systemd_unitdir}/network
    install -m 0644 ${WORKDIR}/21-ap.network ${D}${systemd_unitdir}/network

    install -d ${D}${systemd_unitdir}/network
    install -m 0644 ${WORKDIR}/25-wlan.network.disabled ${D}${systemd_unitdir}/network

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/network-gadget-init.service ${D}${systemd_system_unitdir}

    install -d ${D}${systemd_system_unitdir}/multi-user.target.wants
    ln -s ${systemd_system_unitdir}/network-gadget-init.service ${D}${systemd_system_unitdir}/multi-user.target.wants/network-gadget-init.service
}