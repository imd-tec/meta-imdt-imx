# Copyright (c) 2022 IMD Technologies
# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the core image with IMDT's demo applications"

require recipes-core/images/imdt-image-minimal.bb

IMAGE_FEATURES:append = " \
    nfs-server \
    tools-debug \
"

IMAGE_INSTALL:append = " \
    curl \
    imdt-pico-demos \
    packagegroup-fsl-gstreamer1.0 \
    packagegroup-fsl-gstreamer1.0-full \
    packagegroup-fsl-tools-audio \
    v4l-utils \
    iperf3 \
    alsa-utils \
    alsa-tools \
    libiio \
    libiio-python3 \
    kernel-iio-tools \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'pciutils', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'hailo-firmware hailo-pci hailortcli libhailort', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'libgsthailo libgsthailotools hailo-post-processes tappas-tracers', '', d)} \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'imdt-hailo-demos', '', d)} \
    imdt-pico-modem \
"

export IMAGE_BASENAME = "imdt-image-core"
