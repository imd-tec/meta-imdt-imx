# Copyright (c) 2022 IMD Technologies
# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the core image with IMDT's demo applications"

inherit core-image

IMAGE_FEATURES += " \
    debug-tweaks \
    package-management \
    nfs-server \
    tools-debug \
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
    curl \
    linux-firmware-ap1302 \
    imdt-pico-demos \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    packagegroup-fsl-tools-audio \
    v4l-utils \
    iperf3 \
    alsa-utils \
    alsa-tools \
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
    libiio \
    libiio-python3 \
    kernel-iio-tools \
    ${@bb.utils.contains('MACHINE_FEATURES', 'nxp8997', 'openobex murata-binaries obexftp glibc-gconv-utf-16 glibc-utils', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-ethernet', 'imdt-ethernet-utils', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'pciutils', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'hailo-firmware hailo-pci hailortcli libhailort', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'libgsthailo libgsthailotools hailo-post-processes tappas-tracers', '', d)} \
    imdt-pico-modem \
"

# Set the default target
SYSTEMD_DEFAULT_TARGET = "multi-user.target"

export IMAGE_BASENAME = "imdt-image-core"
