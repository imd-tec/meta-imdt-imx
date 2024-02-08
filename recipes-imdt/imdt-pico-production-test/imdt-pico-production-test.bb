LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"
SRC_URI = "file://imdt-pico-production-test-dev-1.0.0.tar.gz"

PV = "1.0.0"
S = "${WORKDIR}/imdt-pico-production-test-dev-1.0.0"

inherit cmake

DEPENDS += "gstreamer1.0 glib-2.0 opencv"
RDEPENDS_${PN} += "gstreamer1.0 glib-2.0 opencv"

FILES_${PN} = " \
    /pico-production-test/ \
"
