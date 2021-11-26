LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "git://github.com/xtensor-stack/xtensor.git;protocol=https"
SRCREV = "825c0fd8a465049c06ad89fa3911b342dbffcabf"
PV = "0.24.0"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE = ""

DEPENDS = "xsimd xtl"
RDEPENDS_${PN} += "xsimd xtl"

ALLOW_EMPTY_${PN} = "1"
