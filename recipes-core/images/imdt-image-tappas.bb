# Copyright (c) 2022 IMD Technologies
# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the core image with IMDT's demo applications and hailo tappas-apps"

require imdt-image-core.bb

IMAGE_FEATURES += " \
    splash \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
      bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"

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
    packagegroup-imx-security \
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
    ${OPENCV_PKGS} \
"


IMAGE_INSTALL_append_imdt-pico = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'tappas-apps ', '', d)} \
    imdt-pico-modem \
"


export IMAGE_BASENAME = "imdt-image-tappas"
