# Copyright (C) 2015 Freescale Semiconductor
# Copyright 2017-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "NXP Image to validate i.MX machines. \
This image contains everything used to test i.MX machines including GUI, \
demos and lots of applications. This creates a very large image, not \
suitable for production."
LICENSE = "MIT"

require recipes-core/images/imdt-image-multimedia.bb

### WARNING: This image is NOT suitable for production use and is intended
###          to provide a way for users to reproduce the image used during
###          the validation process of i.MX BSP releases.

IMAGE_INSTALL:append = " \
    packagegroup-imx-ml \
    tzdata \
    imagemagick \
"

TOOLCHAIN_TARGET_TASK:append += "tensorflow-lite-dev armnn-dev onnxruntime-dev"

export IMAGE_BASENAME = "imdt-image-multimedia-ml"