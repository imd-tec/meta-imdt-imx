# Copyright (c) 2022 IMD Technologies

DESCRIPTION = "Create a SWUpdate image for the Pico board"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

inherit swupdate

SRC_URI_imdt-pico-e = " \
    file://sw-description \
    file://update.sh \
"

# Dependencies to build before creating the SWUpdate image
IMAGE_DEPENDS = "imdt-image-mm-chromium-beta"


SWUPDATE_IMAGES_imdt-pico-e = " \
    Image \
    imx8mp-imdt-pico-e.dtb \
    tee.bin \
    imdt-image-mm-chromium-beta-imx8mp-imdt-pico-e \
"

# SWUpdate requires that the root filesystem be compressed using GZip
SWUPDATE_IMAGES_FSTYPES[imdt-image-mm-chromium-beta-imx8mp-imdt-pico-e] = ".tar.gz"
