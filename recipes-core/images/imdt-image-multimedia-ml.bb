# Copyright (C) 2015 Freescale Semiconductor
# Copyright 2017-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "NXP Image to validate i.MX machines. \
This image contains everything used to test i.MX machines including GUI, \
demos and lots of applications. This creates a very large image, not \
suitable for production."
LICENSE = "MIT"

inherit core-image

### WARNING: This image is NOT suitable for production use and is intended
###          to provide a way for users to reproduce the image used during
###          the validation process of i.MX BSP releases.

## Select Image Features
IMAGE_FEATURES += " \
    debug-tweaks \
    tools-profile \
    tools-sdk \
    package-management \
    splash \
    nfs-server \
    tools-debug \
    ssh-server-dropbear \
    tools-testapps \
    hwcodecs \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"
ERPC_COMPS ?= ""
ERPC_COMPS_append_mx7ulp = "packagegroup-imx-erpc"

V2X_PKGS = ""
V2X_PKGS_mx8dxl = "packagegroup-imx-v2x"

CORE_IMAGE_EXTRA_INSTALL += " \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-audio \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    packagegroup-imx-isp \
    packagegroup-imx-security \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    yavta \
    firmwared \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
    ${V2X_PKGS} \
"

# Add opencv for i.MX GPU
OPENCV_PKGS       ?= ""
OPENCV_PKGS_imxgpu = " \
    opencv-apps \
    opencv-samples \
    python3-opencv \
"

IMAGE_INSTALL_append = " \
    libgpiod-tools \
    packagegroup-imx-ml \
    tzdata \
    ${OPENCV_PKGS} \
    linux-firmware-ap1302 \
    imdt-pico-demos \
    v4l-utils \
    imagemagick \
    iperf3 \
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
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'pciutils', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'hailo-firmware hailo-pci hailortcli libhailort', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'libgsthailo libgsthailotools hailo-post-processes tappas-tracers', '', d)} \
"

TOOLCHAIN_TARGET_TASK_append += " tensorflow-lite-dev armnn-dev onnxruntime-dev"

# Set the default target
SYSTEMD_DEFAULT_TARGET = "multi-user.target"
