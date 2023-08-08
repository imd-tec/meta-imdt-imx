# Original source: http://github.com/umlaeute/v4l2loopback

SUMMARY = "Configuration of v4l2loopback which creates V4L2 loopback devices"
DESCRIPTION = "v4l2loopback-cntl"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

#DEPENDS = "virtual/kernel"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/umlaeute/v4l2loopback;protocol=https;branch=main \
"

PV = "0.9.1+git${SRCPV}"
SRCREV = "9ba7e294ea6f45410a15f192381d4918e8df4f02"

S = "${WORKDIR}/git"

CFLAGS += "--sysroot=${STAGING_DIR_TARGET}"

MODULES_INSTALL_TARGET = "install-utils"

do_compile() {
    oe_runmake utils
}

do_install() {
    oe_runmake install-utils DESTDIR=${D} BINDIR=${bindir}
}

FILES_${PN} += "${bindir}/v4l2loopback-ctl"

