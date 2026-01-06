# Copyright (c) 2022 IMD Technologies
# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the demo image which adds on the NXP Demo Experience onto the multimedia image"

require recipes-core/images/imdt-image-multimedia.bb

inherit populate_sdk_qt6

IMAGE_INSTALL:append = " \
    packagegroup-imx-ml \
    packagegroup-qt6-imx \
    tzdata \
    imx-g2d-samples \
    packagegroup-imx-isp \
    packagegroup-imx-gopoint \
"

IMAGE_FSTYPES="wic.gz"

export IMAGE_BASENAME = "imdt-image-nxp-demo"