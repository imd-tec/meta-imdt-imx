#
# Copyright (c) 2022 IMD Technologies
#

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "file://imdt-libhttpserver-0.1.0.tar.gz"
PV = "0.1.0"

S = "${WORKDIR}/imdt-libhttpserver-0.1.0"

inherit cmake pkgconfig

EXTRA_OECMAKE = ""

DEPENDS += "openssl glog"
RDEPENDS_${PN} += "openssl"
