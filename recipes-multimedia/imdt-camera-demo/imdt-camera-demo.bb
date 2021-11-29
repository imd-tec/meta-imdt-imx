#
# Copyright (c) 2021 IMD Technologies
#

LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://git@github.com/imd-tec/imdt-camera-demo.git;protocol=ssh;branch=main"
SRCREV = "85b5a14b3a132f2c9c4351f01706a14573ffc9c6"
PV = "1.1.0"

S = "${WORKDIR}/git"

do_install() {
    oe_runmake install DESTDIR=${D}
}

FILES_${PN} = " \
    /etc/systemd/system/ \
    /etc/systemd/system/multi-user.target.wants/ \
    /opt/imdt/camera-demo/bin/ \
    /opt/imdt/camera-demo/www/ \
"
