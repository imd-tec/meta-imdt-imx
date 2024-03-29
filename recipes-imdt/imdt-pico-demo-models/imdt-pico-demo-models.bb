#
# Copyright (c) 2022 IMD Technologies
#

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

PV = "2.0.1"

# This old google drive URL now has a virus scanner message on it.
# https://drive.google.com/uc?export=download&id=1WTDOAYvLgzYAfgxquToS1azUjTVcksiY&authuser=0&confirm=t

# This is obtained by inspection of the virus scan warning dialog.
# (Will it continue to work?)
GOOGLE_DRIVE_URL = "https://drive.usercontent.google.com/download?id=1WTDOAYvLgzYAfgxquToS1azUjTVcksiY&export=download&authuser=0&confirm=t&uuid=dcad0ce4-4d91-42d2-b7ec-9bd3cbab0c3a&at=APZUnTX4FnEdVdnC1DSKp0qSGjXS%3A1707403839642"

SRC_URI = "${GOOGLE_DRIVE_URL};downloadfilename=${BPN}-${PV}.tar.gz"
SRC_URI[sha256sum] = "548ee123cade1c1e00b4d2f95b9faa836e2a4d17c334893e885a79284c52094d"

SRC_URI_append = " \
    file://imdt-ml-cache.sh \
"

do_install() {
    install -d ${D}${sysconfdir}/profile.d/
    install -m 0755 ${WORKDIR}/imdt-ml-cache.sh ${D}${sysconfdir}/profile.d/imdt-ml-cache.sh

    install -d ${D}/opt/imdt/ml-cache/
    install -m 0644 ${WORKDIR}/e6c366ad3c3c0e05a50a8ed15094c957.nb ${D}/opt/imdt/ml-cache/
    install -m 0644 ${WORKDIR}/84875b9710ac5711d3dc7fb4f51aa525.nb ${D}/opt/imdt/ml-cache/
    install -m 0644 ${WORKDIR}/ccd7406cea9f8294aba67d5e0a0162fe.nb ${D}/opt/imdt/ml-cache/

    install -d ${D}/opt/imdt/pico-demos/models/
    install -m 0644 ${WORKDIR}/imdt-single-lpr-quantised.tflite ${D}/opt/imdt/pico-demos/models/
    install -m 0644 ${WORKDIR}/imdt-yolov4-224-quantised.tflite ${D}/opt/imdt/pico-demos/models/
    install -m 0644 ${WORKDIR}/imdt-yolov4-tiny-352-quantised.tflite ${D}/opt/imdt/pico-demos/models/
}

FILES_${PN}_append = " \
    /opt/imdt/ml-cache/ \
    /opt/imdt/pico-demos/models/ \
"
