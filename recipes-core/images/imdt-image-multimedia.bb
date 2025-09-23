# Copyright (c) 2022 IMD Technologies
# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the core image with multimedia packages"

require recipes-core/images/imdt-image-core.bb

## Select Image Features
IMAGE_FEATURES:append = " \
    splash \
    tools-profile \
    tools-sdk \
    tools-testapps \
    ${@bb.utils.contains('DISTRO_FEATURES', 'wayland', 'weston', \
       bb.utils.contains('DISTRO_FEATURES',     'x11', 'x11-base x11-sato', \
                                                       '', d), d)} \
"

IMAGE_INSTALL:append = " \
    opencv-apps \
    opencv-samples \
    python3-opencv \
    packagegroup-core-full-cmdline \
    packagegroup-tools-bluetooth \
    packagegroup-fsl-tools-gpu \
    packagegroup-fsl-tools-gpu-external \
    packagegroup-fsl-tools-testapps \
    packagegroup-fsl-tools-benchmark \
    packagegroup-imx-security \
    yavta \
    ${@bb.utils.contains('DISTRO_FEATURES', 'x11 wayland', 'weston-xwayland xterm', '', d)} \
"

IMAGE_FSTYPES="wic.gz tar.zst"

# Commented out since it doesn't build with the current BSP
#IMAGE_INSTALL:append =     " packagegroup-imx-isp"
export IMAGE_BASENAME = "imdt-image-multimedia"