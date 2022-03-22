#
# Copyright (c) 2022 IMD Technologies
#

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "git://git@github.com/imd-tec/imdt-pico-demos.git;protocol=ssh;branch=main"
SRCREV = "74958ca3236d7dde4d5e5372267948253375651a"
PV = "2.0.1"

S = "${WORKDIR}/git"

inherit cmake pkgconfig systemd

EXTRA_OECMAKE = ""

do_install_append_imx8mp-imdt-picoevk() {
    install -d ${D}/opt/imdt/pico-demos/sysfs/
    ln -s /sys/devices/platform/soc@0/30800000.bus/30a50000.i2c/i2c-3/3-003c/face_detection ${D}/opt/imdt/pico-demos/sysfs/face_detection
}

do_install_append_imx8mp-imdt-uevk() {
    install -d ${D}/opt/imdt/pico-demos/sysfs/
    ln -s /sys/devices/platform/soc@0/30800000.bus/30a30000.i2c/i2c-1/1-003c/face_detection ${D}/opt/imdt/pico-demos/sysfs/face_detection
}

do_install_append_imx8mp-imdt-uevk-2g() {
    install -d ${D}/opt/imdt/pico-demos/sysfs/
    ln -s /sys/devices/platform/soc@0/30800000.bus/30a30000.i2c/i2c-1/1-003c/face_detection ${D}/opt/imdt/pico-demos/sysfs/face_detection
}

DEPENDS = "libpicosupport imdt-pico-demo-models tensorflow-lite flatbuffers opencv xtensor"
RDEPENDS_${PN} = "libpicosupport imdt-pico-demo-models tensorflow-lite flatbuffers opencv xtensor"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "imdt-web-server.service"

FILES_${PN}_append = " \
    /opt/imdt/pico-demos/ \
    ${systemd_unitdir}/system/ \
"
