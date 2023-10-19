SUMMARY = "Python support for gpiod"
DESCRIPTION = "Python support for gpiod"
HOMEPAGE = "https://github.com/hhk7734/python3-gpiod"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

inherit pypi setuptools3

SRC_URI[sha256sum] = "d8e4daa655dee75c33a49f5859b2e36c72385021c06c5552968294b1ad5c2dd0"

CLEANBROKEN = "1"

PYPI_PACKAGE = "gpiod"

RDEPENDS_${PN} += "\
        ${PYTHON_PN}-ctypes \
        ${PYTHON_PN}-fcntl \
"
