#
# Copyright (c) 2022 IMD Technologies
#

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "git://git@github.com/imd-tec/imdt-pico-demos.git;protocol=ssh;branch=main"
SRCREV = "0f252c2a322cb59c3a1c3483a32db8b39814c69f"
PV = "2.1.0"

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

DEPENDS = "libpicosupport imdt-pico-demo-models tensorflow-lite flatbuffers opencv xtensor nlohmann-json"
RDEPENDS_${PN} = "libpicosupport imdt-pico-demo-models tensorflow-lite flatbuffers opencv xtensor"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "imdt-web-server.service"

FILES_${PN}_append = " \
    /opt/imdt/pico-demos/ \
    ${systemd_unitdir}/system/ \
"
