#
# Copyright (c) 2023 IMD Technologies
#

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

PV = "1.0.0"

SRC_URI = "git://git@github.com/imd-tec/imdt-hailo-demo-models.git;protocol=ssh;branch=master"
SRCREV = "f1ece21e9b63a996f16dbb3b7aed8c80ca7f0dba"

do_install() {
    install -d ${D}/opt/imdt/pico-demos/models/
    install -m 0644 ${WORKDIR}/git/yolov5m.hef ${D}/opt/imdt/pico-demos/models/
}

FILES_${PN}_append = " \
    /opt/imdt/pico-demos/models/ \
"
