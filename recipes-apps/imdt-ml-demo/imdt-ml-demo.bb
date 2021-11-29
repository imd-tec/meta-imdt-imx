#
# Copyright (c) 2021 IMD Technologies
#

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

SRC_URI = "git://git@github.com/imd-tec/imdt-machine-learning-demos.git;protocol=ssh;branch=main"
SRCREV = "${AUTOREV}"
PV = "0.1.0"

SRC_URI_append = " \
    file://imdt-ml-cache.sh \
    file://imdt-yolov4-tiny-quantised.tflite \
"

S = "${WORKDIR}/git"

inherit cmake pkgconfig

EXTRA_OECMAKE = ""

do_install_append() {
    install -d ${D}${sysconfdir}/profile.d/
    install -m 0755 ${WORKDIR}/imdt-ml-cache.sh ${D}${sysconfdir}/profile.d/imdt-ml-cache.sh

    install -d ${D}/opt/imdt/models/
    install -m 0644 ${WORKDIR}/imdt-yolov4-tiny-quantised.tflite ${D}/opt/imdt/models/
}

DEPENDS = "tensorflow-lite flatbuffers opencv xtensor"
RDEPENDS_${PN} = "tensorflow-lite flatbuffers opencv xtensor"

FILES_${PN}_append = " \
    /opt/imdt/models/ \
"
