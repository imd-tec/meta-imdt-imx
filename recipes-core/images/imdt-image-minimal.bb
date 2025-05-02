# Copyright (c) 2021 IMD Technologies
# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the basic core image with minimal tests"

inherit core-image

ROOTFS_POSTPROCESS_COMMAND += "write_issue_file;"

write_issue_file() {
    ISSUE_FILE="${IMAGE_ROOTFS}/etc/issue"
    MANIFEST_DIR="${TOPDIR}/../.repo/manifests"
    BSP_VERSION="0.0.0"
    MANIFEST_NAME="Unknown"

    if [ -d "${MANIFEST_DIR}" ]; then
        INCLUDED_MANIFEST=$(sed -n 's/.*<include name="\([^"]*\)".*/\1/p' ${TOPDIR}/../.repo/manifest.xml)
        INCLUDED_MANIFEST_PATH="${MANIFEST_DIR}/${INCLUDED_MANIFEST}"

        if [ -f "${INCLUDED_MANIFEST_PATH}" ]; then
            LINE=$(sed -n 's/.*<manifest \([^>]*\).*/\1/p' ${INCLUDED_MANIFEST_PATH})
            MANIFEST_NAME=$(echo $LINE | sed -n 's/.*name="\([^"]*\)".*/\1/p')
            BSP_VERSION=$(echo $LINE | sed -n 's/.*version="\([^"]*\)".*/\1/p')
            [ -z "$BSP_VERSION" ] && BSP_VERSION="NO_VERSION_TAG"
        fi
    fi

    echo "IMDT Pico BSP v${BSP_VERSION}, Image: ${IMAGE_BASENAME}, Manifest: ${MANIFEST_NAME}" > $ISSUE_FILE
}

IMAGE_FEATURES_append = " \
    debug-tweaks \
    package-management \
    ssh-server-dropbear \
    hwcodecs \
"
SDKIMAGE_FEATURES_append = " \
    staticdev-pkgs \
"

IMAGE_INSTALL_append = " \
    libgpiod-tools \
    imx-test \
    firmwared \
    packagegroup-imx-core-tools \
    packagegroup-imx-security \
    linux-firmware-ap1302 \
    swupdate \
    swupdate-progress \
    swupdate-www \
    u-boot-fw-utils \
    wpa-supplicant \
    wireless-tools \
    hostapd \
    dhcpcd \
    wireless-regdb-static \
    imdt-bt-utils \
    imdt-wifi-utils \
    lmsensors \
    ${@bb.utils.contains('MACHINE_FEATURES', 'nxp8997', 'openobex murata-binaries obexftp glibc-gconv-utf-16 glibc-utils', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-ethernet', 'imdt-ethernet-utils', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-can', 'libsocketcan can-utils imdt-can-utils', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-rng', 'imdt-rng-test', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-rtc', 'imdt-rtc-utils', '', d)} \
"
IMAGE_FSTYPES="wic.gz tar.gz"
# Set the default target
SYSTEMD_DEFAULT_TARGET = "multi-user.target"

export IMAGE_BASENAME = "imdt-image-minimal"
