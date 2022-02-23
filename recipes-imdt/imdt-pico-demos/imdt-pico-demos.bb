#
# Copyright (c) 2022 IMD Technologies
#

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "git://git@github.com/imd-tec/imdt-pico-demos.git;protocol=ssh;branch=main"
SRCREV = "${AUTOREV}"
PV = "2.0.0"

S = "${WORKDIR}/git"

inherit cmake pkgconfig systemd

EXTRA_OECMAKE = ""

DEPENDS = "libpicosupport imdt-pico-demo-models tensorflow-lite flatbuffers opencv xtensor"
RDEPENDS_${PN} = "libpicosupport imdt-pico-demo-models tensorflow-lite flatbuffers opencv xtensor"

SYSTEMD_AUTO_ENABLE = "enable"
SYSTEMD_SERVICE_${PN} = "imdt-web-server.service"

FILES_${PN}_append = " \
    /opt/imdt/pico-demos/ \
    ${systemd_unitdir}/system/ \
"
