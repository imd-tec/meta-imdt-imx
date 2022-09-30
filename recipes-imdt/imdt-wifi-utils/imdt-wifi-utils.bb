#
# Copyright (c) 2022 IMD Technologies
#

DESCRIPTION = "Utilities for controlling and configuring the Pico WiFi adapter"

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

PV = "1.0.0"

SRC_URI = " \
    file://connect-to-access-point.sh \
    file://create-access-point.sh \
    file://disable-wifi.sh \
    file://get-connection-status.sh \
    file://get-number-of-ap-clients.sh \
    file://get-wifi-mode.sh \
    file://wifi-lib.sh \
"

do_install() {
    install -d ${D}/opt/imdt/wifi
    install -m 0744 ${WORKDIR}/connect-to-access-point.sh ${D}/opt/imdt/wifi
    install -m 0744 ${WORKDIR}/create-access-point.sh ${D}/opt/imdt/wifi
    install -m 0744 ${WORKDIR}/disable-wifi.sh ${D}/opt/imdt/wifi
    install -m 0744 ${WORKDIR}/get-connection-status.sh ${D}/opt/imdt/wifi
    install -m 0744 ${WORKDIR}/get-number-of-ap-clients.sh ${D}/opt/imdt/wifi
    install -m 0744 ${WORKDIR}/get-wifi-mode.sh ${D}/opt/imdt/wifi
    install -m 0644 ${WORKDIR}/wifi-lib.sh ${D}/opt/imdt/wifi
}

FILES_${PN} += " \
    /opt/imdt/wifi/ \
"

RDEPENDS_${PN} += "bash"
