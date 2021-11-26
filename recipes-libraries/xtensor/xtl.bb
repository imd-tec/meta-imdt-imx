LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/BSD-3-Clause;md5=550794465ba0ec5312d6919e203a55f9"

SRC_URI = "git://github.com/xtensor-stack/xtl.git;protocol=https"
SRCREV = "46f8a9390db2c52aaf41de8f93ed0dab97af012d"
PV = "0.7.3"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE = ""

ALLOW_EMPTY_${PN} = "1"
