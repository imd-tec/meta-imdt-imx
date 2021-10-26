#
# Copyright (c) 2021 IMD Technologies
#

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESPATHS := "${THISDIR}/files:"

SRC_URI = " \
    file://bin/ \
    file://system/ \
    file://www/ \
"

do_install() {

    install -d ${D}/opt/imdt/camera-demo/bin
    install -m 0744 ${WORKDIR}/bin/* ${D}/opt/imdt/camera-demo/bin

    install -d ${D}${systemd_unitdir}/system/
    install -m 0644 ${WORKDIR}/system/* ${D}${systemd_unitdir}/system

    install -d ${D}${sysconfdir}/systemd/system/multi-user.target.wants/
    ln -s ${systemd_unitdir}/system/imdt-web-server.service ${D}${sysconfdir}/systemd/system/multi-user.target.wants/imdt-web-server.service

    install -d ${D}/opt/imdt/camera-demo/www
    cp -R --no-dereference --preserve=mode,links -v ${WORKDIR}/www/* ${D}/opt/imdt/camera-demo/www

}

FILES_${PN} = " \
    /opt/imdt/camera-demo/bin/ \
    ${systemd_unitdir}/system/ \
    ${sysconfdir}/systemd/system/multi-user.target.wants/ \
    /opt/imdt/camera-demo/www/ \
"
