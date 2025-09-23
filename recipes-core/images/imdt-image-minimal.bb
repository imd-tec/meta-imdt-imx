# Copyright (c) 2021 IMD Technologies
# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the basic core image with minimal tests"

inherit core-image

ROOTFS_POSTPROCESS_COMMAND += "write_issue_file;"

write_issue_file() {

    ISSUE_FILE="${IMAGE_ROOTFS}/etc/issue"
    BSP_VERSION="0.0.0"
    KAS_GIT_REPO_DIR="${TOPDIR}/.."
    KAS_GIT_REPO_DIR_CONTAINER="/repo"

    if [ -d "${KAS_GIT_REPO_DIR}/.git" ]; then
        GIT_DIR="${KAS_GIT_REPO_DIR}/.git"
        BSP_VERSION=$(git --git-dir="$GIT_DIR" describe --tags --always 2>/dev/null)
    elif [ -d "${KAS_GIT_REPO_DIR_CONTAINER}/.git" ]; then
        GIT_DIR="${KAS_GIT_REPO_DIR_CONTAINER}/.git"
        BSP_VERSION=$(git --git-dir="$GIT_DIR" describe --tags --always 2>/dev/null)
    fi
    
    echo "IMDT Pico BSP ${BSP_VERSION}, Image: ${IMAGE_BASENAME}" > "${ISSUE_FILE}"
}

IMAGE_FEATURES:append = " \
    debug-tweaks \
    package-management \
    ssh-server-dropbear \
    hwcodecs \
"
SDKIMAGE_FEATURES:append = " \
    staticdev-pkgs \
"

IMAGE_INSTALL:append = " \
    libgpiod-tools \
    imx-test \
    firmwared \
    packagegroup-imx-core-tools \
    packagegroup-imx-security \
    linux-firmware-ap1302 \
    u-boot-fw-utils \
    wpa-supplicant \
    wireless-tools \
    hostapd \
    dhcpcd \
    wireless-regdb-static \
    imdt-bt-utils \
    imdt-wifi-utils \
    lmsensors \
	swupdate \
	swupdate-progress \
	swupdate-www \
	swupdate-tools \
    u-boot-imx \
    ${@bb.utils.contains('MACHINE_FEATURES', 'nxp8997-sdio', 'openobex obexftp glibc-gconv-utf-16 glibc-utils', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-ethernet', 'imdt-ethernet-utils', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-can', 'libsocketcan can-utils imdt-can-utils', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-rng', 'imdt-rng-test', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-rtc', 'imdt-rtc-utils', '', d)} \
"
IMAGE_FSTYPES="wic.gz tar.gz"

# Set the default target
SYSTEMD_DEFAULT_TARGET = "multi-user.target"

export IMAGE_BASENAME = "imdt-image-minimal"
