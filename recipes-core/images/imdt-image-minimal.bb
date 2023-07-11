# Copyright (c) 2021 IMD Technologies
# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the basic core image with minimal tests"

inherit core-image

IMAGE_FEATURES += " \
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
"

IMAGE_INSTALL_append_imdt-pico = " \
    wpa-supplicant \
    wireless-tools \
    hostapd \
    dhcpcd \
    wireless-regdb-static \
    imdt-bt-utils \
    imdt-wifi-utils \
    lmsensors \
    ${@bb.utils.contains('MACHINE_FEATURES', 'nxp8997', 'openobex murata-binaries obexftp glibc-gconv-utf-16 glibc-utils', '', d)} \
"

# Set the default target
SYSTEMD_DEFAULT_TARGET = "multi-user.target"

export IMAGE_BASENAME = "imdt-image-minimal"
