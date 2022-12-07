#
# Copyright (c) 2022 IMD Technologies
#

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "file://imdt-libpicosupport-0.4.0.tar.gz"
PV = "0.4.0"

S = "${WORKDIR}/imdt-libpicosupport-0.4.0"

inherit cmake pkgconfig use-imx-headers

EXTRA_OECMAKE += "-DCMAKE_CXX_FLAGS='${CXXFLAGS} -I${STAGING_INCDIR_IMX}'"

DEPENDS += "libpng libjpeg-turbo opencv imx-vpuwrap linux-imx-headers"
RDEPENDS_${PN} += "libpng libjpeg-turbo opencv imx-vpuwrap"
