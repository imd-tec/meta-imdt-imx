#
# Copyright (c) 2022 IMD Technologies
#

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

SRC_URI = "file://imdt-hailo-demos-4.0.0+0+00dfe2c6e3-r0.cortexa53_crypto_mx8mp.rpm;subdir=rpm"
PV = "4.0.0"

S = "${WORKDIR}/rpm"

DEPENDS = "opencv"
RDEPENDS_${PN} = "libpicosupport imdt-hailo-demo-models imdt-pico-demos opencv libhttpserver glog libhailort"

# Copy the contents of the RPM to the root filesystem
do_install_append() {
    cp -R ${S}/* ${D}
}

# Executables have already have their symbols stripped
INSANE_SKIP_${PN}_append = "already-stripped"

FILES_${PN} = " \
    /etc/opt/imdt/pico-demos/ \
    ${systemd_unitdir}/system/ \
    ${systemd_unitdir}/system-preset/ \
    /opt/imdt/pico-demos/ \
    /usr/bin/ \
"
