# Copyright (c) 2022 IMD Technologies
# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the core image with IMDT's demo applications and hailo tappas-apps"

require recipes-core/images/imdt-image-multimedia.bb

IMAGE_INSTALL:remove = "packagegroup-fsl-gstreamer1.0 packagegroup-fsl-gstreamer1.0-full"

IMAGE_INSTALL:append = " \
    ${@bb.utils.contains('MACHINE_FEATURES', 'imdt-pci', 'tappas-apps imdt-tappas-demos', '', d)} \
"

export IMAGE_BASENAME = "imdt-image-tappas"
