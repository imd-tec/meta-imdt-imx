#
# Copyright (c) 2022 IMD Technologies
#

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "git://git@github.com/imd-tec/imdt-libpicosupport.git;protocol=ssh;branch=main"
SRCREV = "f8cb06aa9f9b7ed4597dbc0af083dd7306903215"
PV = "0.1.0"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE = ""

DEPENDS += "libpng libjpeg-turbo"
RDEPENDS_${PN} += "libpng libjpeg-turbo"
