#
# Copyright (c) 2023 IMD Technologies
#

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "file://imdt-pico-modem-1.0.0+0+6115489d25-r0.cortexa53_crypto.rpm;subdir=rpm"
PV = "1.0.0"

S = "${WORKDIR}/rpm"

DEPENDS = ""
RDEPENDS_${PN} = "libpicosupport libgpiod libqmi glib-2.0 "

# Copy the contents of the RPM to the root filesystem
do_install_append() {
    cp -R ${S}/* ${D}
}

# Executables have already have their symbols stripped
INSANE_SKIP_${PN}_append = "already-stripped"

FILES_${PN} = " \
    /usr/bin/ \
"
