LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "git://github.com/xtensor-stack/xsimd.git;protocol=https"
SRCREV = "07453a2b5a25e7424c71ab9fc365f83b380f9964"
PV = "8.0.3"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE = ""

DEPENDS = "xtl"
RDEPENDS_${PN} += "xtl"
