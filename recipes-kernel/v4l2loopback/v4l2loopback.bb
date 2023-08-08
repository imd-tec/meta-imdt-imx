# Original source: http://github.com/umlaeute/v4l2loopback
#
# To develop patches
# ------------------
# https://github.com/imd-tec/v4l2loopback-dev
# Branch: imdt-5.10.72
# 
# Create patches
# --------------
# git pull
# git format-patch 9ba7e294ea6f45410a15f192381d4918e8df4f02..HEAD
#

inherit module 

SUMMARY = "Kernel module to create V4L2 loopback devices"
DESCRIPTION = "v4l2loopback"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=b234ee4d69f5fce4486a80fdaf4a4263"

DEPENDS = "virtual/kernel"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI = "git://github.com/umlaeute/v4l2loopback;protocol=https;branch=main \
    file://0001-Update-Makefile-for-building-ko-under-yocto.patch \
    "

PV = "0.9.1+git${SRCPV}"
SRCREV = "9ba7e294ea6f45410a15f192381d4918e8df4f02"

S = "${WORKDIR}/git"

CFLAGS += "--sysroot=${STAGING_DIR_TARGET}"

KERNEL_MODULE_AUTOLOAD = "v4l2loopback"

MODULES_INSTALL_TARGET = "install"


do_compile() {
    oe_runmake v4l2loopback.ko
}
