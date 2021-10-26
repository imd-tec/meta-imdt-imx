# Copyright (c) 2021 IMD Technologies
# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the basic core image with minimal tests"

inherit core-image

IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    tools-sdk \
    package-management \
    splash \
    nfs-server \
    tools-debug \
    ssh-server-dropbear \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston','', d)} \
"
SDKIMAGE_FEATURES_append = " \
    staticdev-pkgs \
"
CLINFO ?= ""
CLINFO_imxgpu = "clinfo"
CLINFO_mx8mm = ""

IMAGE_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    imx-test \
    firmwared \
    packagegroup-imx-core-tools \
    packagegroup-imx-security \
    curl \
    linux-firmware \
    ${CLINFO} \
"

IMAGE_INSTALL_append_imx8mp-imdt-picoevk = " \
    wpa-supplicant wireless-tools hostapd dhcpcd wireless-regdb-static \
    imdt-camera-demo \
"

export IMAGE_BASENAME = "imdt-image-core"
