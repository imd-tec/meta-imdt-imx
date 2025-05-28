#
# Copyright (c) 2024 IMD Technologies
#

DESCRIPTION = "node.js and npm and electron hello world"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

DEPENDS = " gtk+3 nodejs-native cups"

# Define the npm package to install
PACKAGE = "electron@11.5.0"

SRC_URI = " \
    file://preload.js \
    file://index.html \
    file://main.js \
    file://package.json \
"

do_install() {
    install -d ${D}/home/root/electron-example
    install -m 0744 ${WORKDIR}/preload.js ${D}/home/root/electron-example
    install -m 0744 ${WORKDIR}/index.html ${D}/home/root/electron-example
    install -m 0744 ${WORKDIR}/main.js ${D}/home/root/electron-example
    install -m 0744 ${WORKDIR}/package.json ${D}/home/root/electron-example

    cd ${WORKDIR}

    npm install --arch=arm64 ${PACKAGE} --save-dev
    cp -r ${WORKDIR}/node_modules ${D}/home/root/electron-example
}

FILES_${PN} += " \
    /home/root/electron-example \
"

RDEPENDS_${PN} += " \
    alsa-lib \
    nss \
    nspr \
    nodejs \
    nodejs-npm \
    at-spi2-atk \
    at-spi2-core \
    libxcomposite \
"
