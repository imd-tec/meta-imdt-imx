# Copyright (c) 2022 IMD Technologies

DESCRIPTION = "Create a SWUpdate image for the Pico board"

LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/Proprietary;md5=0557f9d92cf58f2ccdd50f62f8ac0b28"

inherit swupdate

SRC_URI_imdt-pico-v2 = " \
    file://sw-description \
    file://update.sh \
"

SRC_URI_imdt-pico-v3 = " \
    file://sw-description \
    file://update.sh \
"

SRC_URI_imdt-pico-v3-0004 = " \
    file://sw-description \
    file://update.sh \
"

SRC_URI_imdt-pico-v3-0005 = " \
    file://sw-description \
    file://update.sh \
"

SRC_URI_imdt-pico-e = " \
    file://sw-description \
    file://update.sh \
"

# Dependencies to build before creating the SWUpdate image
IMAGE_DEPENDS = "imdt-image-core"

# Images and files that will be included in the .swu image
SWUPDATE_IMAGES_imdt-pico-v2 = " \
    Image \
    imx8mp-imdt-pico-v2.dtb \
    tee.bin \
    imdt-image-core-imx8mp-imdt-pico-v2 \
"

SWUPDATE_IMAGES_imdt-pico-v3 = " \
    Image \
    imx8mp-imdt-pico-v3.dtb \
    tee.bin \
    imdt-image-core-imx8mp-imdt-pico-v3 \
"

SWUPDATE_IMAGES_imdt-pico-v3-0004 = " \
    Image \
    imx8mp-imdt-pico-v3-0004.dtb \
    tee.bin \
    imdt-image-core-imx8mp-imdt-pico-v3-0004 \
"

SWUPDATE_IMAGES_imdt-pico-v3-0005 = " \
    Image \
    imx8mp-imdt-pico-v3-0005.dtb \
    tee.bin \
    imdt-image-core-imx8mp-imdt-pico-v3-0005 \
"

SWUPDATE_IMAGES_imdt-pico-e = " \
    Image \
    imx8mp-imdt-pico-e.dtb \
    tee.bin \
    imdt-image-core-imx8mp-imdt-pico-e \
"

# SWUpdate requires that the root filesystem be compressed using GZip
SWUPDATE_IMAGES_FSTYPES[imdt-image-core-imx8mp-imdt-pico-v2] = ".tar.gz"
SWUPDATE_IMAGES_FSTYPES[imdt-image-core-imx8mp-imdt-pico-v3] = ".tar.gz"
SWUPDATE_IMAGES_FSTYPES[imdt-image-core-imx8mp-imdt-pico-v3-0004] = ".tar.gz"
SWUPDATE_IMAGES_FSTYPES[imdt-image-core-imx8mp-imdt-pico-v3-0005] = ".tar.gz"
SWUPDATE_IMAGES_FSTYPES[imdt-image-core-imx8mp-imdt-pico-e] = ".tar.gz"
