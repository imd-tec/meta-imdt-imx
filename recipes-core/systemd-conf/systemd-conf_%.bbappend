#
# Copyright (c) 2022 IMD Technologies
#

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI_append = " \
    file://20-usb0.network \
    file://network-gadget-init.service \
    file://21-ap.network \
    file://25-wlan.network.disabled \
    file://19-eth0.network.disabled \
"

FILES_${PN}_append = " \
    ${systemd_unitdir}/network/20-usb0.network \
    ${systemd_system_unitdir}/network-gadget-init.service \
    ${systemd_system_unitdir}/multi-user.target.wants/network-gadget-init.service \
    ${systemd_unitdir}/network/21-ap.network \
    ${systemd_unitdir}/network/25-wlan.network.disabled \
    ${systemd_unitdir}/network/19-eth0.network.disabled \
"

do_install_append() {
    install -d ${D}${systemd_unitdir}/network
    install -m 0644 ${WORKDIR}/20-usb0.network ${D}${systemd_unitdir}/network
    install -m 0644 ${WORKDIR}/21-ap.network ${D}${systemd_unitdir}/network
    install -m 0644 ${WORKDIR}/25-wlan.network.disabled ${D}${systemd_unitdir}/network
    install -m 0644 ${WORKDIR}/19-eth0.network.disabled ${D}${systemd_unitdir}/network

    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/network-gadget-init.service ${D}${systemd_system_unitdir}

    install -d ${D}${systemd_system_unitdir}/multi-user.target.wants
    ln -s ${systemd_system_unitdir}/network-gadget-init.service ${D}${systemd_system_unitdir}/multi-user.target.wants/network-gadget-init.service

    
    
}

