#
# Copyright (c) 2022 IMD Technologies
#

SUMMARY = "Linux kernel provided and supported by IMD Technologies"

SRC_URI = "git://github.com/imd-tec/linux-imdt.git;protocol=https;branch=imdt-6.6.y"
SRCREV = "5663bc368e77a658af8b74472fcf6797650218b3"


IMX_KERNEL_CONFIG_AARCH64:imdt-pico = "imdt_pico_defconfig"

