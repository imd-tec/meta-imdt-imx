# Copyright (c) 2022 IMD Technologies
# Copyright 2018-2021 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

DESCRIPTION = "This is the core image with IMDT's demo applications"

require recipes-core/images/imdt-image-multimedia.bb


IMAGE_INSTALL:append = " \
    git \
    chromium-ozone-wayland \
    node-electron \
    electron-fiddle \
"

export IMAGE_BASENAME = "imdt-image-mm-chromium-beta"
