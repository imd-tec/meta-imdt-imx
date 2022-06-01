#
# Copyright (c) 2022 IMD Technologies
#

DESCRIPTION = "systemd service for use with BCM43XX Bluetooth"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = " \
    file://imdt-bluetooth-init.service \
    file://start.sh \
"

inherit systemd

do_install() {
    install -d ${D}${systemd_system_unitdir}
    install -m 0644 ${WORKDIR}/imdt-bluetooth-init.service ${D}${systemd_system_unitdir}

    install -d ${D}/opt/imdt/bluetooth
    install -m 0744 ${WORKDIR}/start.sh ${D}/opt/imdt/bluetooth
}

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "imdt-bluetooth-init.service"

FILES_${PN} += " \
    /opt/imdt/bluetooth/start.sh \
"
